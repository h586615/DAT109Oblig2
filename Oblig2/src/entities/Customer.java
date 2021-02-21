package entities;

import java.util.Date;
import java.util.List;

import events.Reservation;

public class Customer {

	private String lastname;
	private String surname;
	private Address address;
	private int telephoneNumber;
	public Reservation reservation;

	public Customer(String surname, String lastname, Address address, int phone, Reservation reservation) {
		this.surname = surname;
		this.lastname = lastname;
		this.address = address;
		this.telephoneNumber = phone;
		this.reservation = reservation;
	}
	
	@Override
	public String toString() {
		return "[" + firstName + ", " + lastName + ", address=" + address + ", phone="
		+ phoneNumber + "]";
	

	public void pay() {

	}
}
