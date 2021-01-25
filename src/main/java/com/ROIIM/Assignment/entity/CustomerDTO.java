package com.ROIIM.Assignment.entity;

public class CustomerDTO {
private Customer customer;
private String firstName;
private String lastName;
private String contact;
private Address address;
private String id;
private String locale;
public String merchantCustomerId;
public String getMerchantCustomerId() {
	return merchantCustomerId;
}
public void setMerchantCustomerId(String merchantCustomerId) {
	this.merchantCustomerId = merchantCustomerId;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

public String getLocale() {
	return locale;
}
public void setLocale(String locale) {
	this.locale = locale;
}
@Override
public String toString() {
	return "CustomerDTO [customer=" + customer + ", firstName=" + firstName + ", lastName=" + lastName + ", contact="
			+ contact + ", address=" + address + ", id=" + id + ", locale=" + locale
			+ ", merchantCustomerId=" + merchantCustomerId + "]";
}


}
