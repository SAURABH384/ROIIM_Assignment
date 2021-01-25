package com.ROIIM.Assignment.controller;
import com.ROIIM.Assignment.entity.CustomerToken;
import com.ROIIM.Assignment.entity.Payment;
import com.ROIIM.Assignment.entity.ResponseDTO;
import com.ROIIM.Assignment.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping( "/SingleUseCustomerToken/{emailId}" )
    public ResponseDTO getSingleUseCustomerToken(@PathVariable String emailId ){

        //CheckoutService checkoutService = new CheckoutService();
        ResponseDTO<CustomerToken> responseDTO = new ResponseDTO< CustomerToken >();
        responseDTO.setStatus( HttpStatus.OK );
        responseDTO.setMessage( "SingleUseCustomerToken Created" );
        responseDTO.setData( checkoutService.creatSingleUserCustomerToken( emailId ) );
        return responseDTO;
    }

    @PostMapping( "/MakePayment/{emailId}" )
    public ResponseDTO<Payment> makePayment(@PathVariable String emailId, @RequestBody Payment payment ){

        ResponseDTO<Payment> responseDTO = new ResponseDTO< Payment >();
        responseDTO.setStatus( HttpStatus.OK );
        responseDTO.setMessage( "Payment Done Successfully" );
        responseDTO.setData( checkoutService.makePayment( payment ) );
        return responseDTO;
    }
}
