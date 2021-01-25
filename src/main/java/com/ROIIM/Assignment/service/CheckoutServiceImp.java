package com.ROIIM.Assignment.service;
import com.ROIIM.Assignment.entity.Address;
import com.ROIIM.Assignment.entity.Customer;
import com.ROIIM.Assignment.entity.CustomerDTO;
import com.ROIIM.Assignment.entity.CustomerToken;
import com.ROIIM.Assignment.entity.Payment;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

@Service
public class CheckoutServiceImp implements CheckoutService{
    private CustomerService customerService;
   private RestTemplate restTemplate;
  @Value("${gateway.Url}")
    private String baseurl;
   @Value("${gateway.key}")
    private String APIKeyId;
  @Value("${gateway.value}")
    private String APIKeyPassword;
    private Random rd;
    public CheckoutServiceImp(){}

    
    @Autowired
    public CheckoutServiceImp(CustomerService customerService, RestTemplate restTemplate ){
    	System.out.println(baseurl);
    	System.out.println(APIKeyId);
    	System.out.println(APIKeyPassword);
        this.customerService = customerService;
        this.restTemplate = restTemplate;
        rd = new Random();
    }


    public CustomerToken creatSingleUserCustomerToken( String emailId ){
        Customer customer = null;
        customer = customerService.findUserByEmail( emailId );
        // check if user is previously registered
        if( customer == null ){
            // create a new user
            customer = createCustomer( emailId );
            // check if user is created or not
            if( customer == null ){
                return null;
            }
        }
        // get API url in the string
        String url = baseurl + "/customers/" + customer.getPaysafeId() + "/singleusecustomertokens" ;

        // create new http header and set content type to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set basic authorization with api key and its value
        headers.setBasicAuth( APIKeyId, APIKeyPassword );
        // create request object
        CustomerToken singleUseCustomerToken = new CustomerToken();
        singleUseCustomerToken.setMerchantRefNum( String.valueOf( rd.nextInt() ) );
        singleUseCustomerToken.setPaymentTypes( Arrays.asList( "CARD" ) );
        // convert request object in to json object
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {

            jsonString = objectMapper.writeValueAsString( singleUseCustomerToken );
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // build the request
        HttpEntity< String > entity = new HttpEntity<String>( jsonString, headers );

        // send POST request
        ResponseEntity< CustomerToken > responseEntity = restTemplate.postForEntity( url, entity, CustomerToken.class );
        if( responseEntity.getStatusCode().equals( HttpStatus.CREATED ) ) {
        	CustomerToken customerToken = responseEntity.getBody();
        	customerToken.setMerchantRefNum(singleUseCustomerToken.getMerchantRefNum());
            System.out.println(responseEntity.getBody());
            return responseEntity.getBody();
        }
        return null;
    }
    public Customer createCustomer( String emailId ){
        // get API url in the string
        String url = baseurl + "/customers";
        // create new http header and set content type to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set basic authorization with api key and its value
        headers.setBasicAuth( APIKeyId, APIKeyPassword );
        // create a new map for the body of the request and put all the values received from the user in the map
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setMerchantCustomerId( String.valueOf( rd.nextInt() ) );
        customerDTO.setLocale( "en_US" );
        customerDTO.setFirstName( "saurabh" );
        customerDTO.setLastName("abc" );
        customerDTO.setContact("9087543245");
        Address adr= new Address();
        adr.setCity("NY");
        adr.setCountry("USA");
        adr.setZip("1098732");
        Customer cust= new Customer();
        cust.setEmail(emailId);
        customerDTO.setCustomer(cust);
        customerDTO.setAddress(adr);
        // convert request object in to json object
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {

            jsonString = objectMapper.writeValueAsString(customerDTO);
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println( jsonString );
        // build the request
        HttpEntity< String > entity = new HttpEntity< String >( jsonString, headers );
        // send POST request
        ResponseEntity< CustomerDTO > responseEntity = restTemplate.postForEntity( url, entity, CustomerDTO.class );
        // check if user is successfully created
        if( responseEntity.getStatusCode() == HttpStatus.CREATED ){
            // get the response
        	CustomerDTO response = responseEntity.getBody();
        	//System.out.println( response );
            // create new record for the customer in local database and set it's attributes values
            Customer newCustomer = new Customer();
            newCustomer.setPaysafeId( response.getId() );
            newCustomer.setEmail(emailId);
            customerService.createCustomer( newCustomer );
            customerDTO.setId(newCustomer.getPaysafeId());
            System.out.println(customerDTO);
            return newCustomer;
        }
        else {

            System.out.println( "failed user creation" );

            Customer c = null;
            return c;
        }
    }


    public Payment makePayment( Payment payment ){

       // System.out.println( "In make payment" );

        // create an url for the payemnt api
        String url = baseurl + "/payments";

        // create new http header and set content type to application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // set basic authorization with api key and its value
        headers.setBasicAuth( APIKeyId, APIKeyPassword );

        payment.setCustomerIp( "10.10.12.64" );
        payment.setMerchantRefNum( String.valueOf( rd.nextInt() ) );

        // convert request object into json object
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {

            jsonString = objectMapper.writeValueAsString( payment );
           // System.out.println(jsonString);     
            }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // build the request
        HttpEntity< String > entity = new HttpEntity<String>( jsonString, headers );

        // send POST request
        ResponseEntity<Payment> responseEntity = restTemplate.postForEntity( url, entity, Payment.class );
        //Payment response=responseEntity.getBody();
        if( responseEntity.getStatusCode() != HttpStatus.CREATED ){

            // throw an exception
        }
       // System.out.println(response);
        return responseEntity.getBody();
    }
}
