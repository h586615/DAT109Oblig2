package entities;

import java.util.Date;
import java.util.List;

import events.Reservation;

public class Customer {

	private String lastname;
	private String surname;
	private String address;
	private int telephoneNumber;
	public Reservation reservation;

	public Customer(String lastname, String surname, String address, int phone) {
		this.surname = surname;
		this.lastname = lastname;
		this.address = address;
		this.telephoneNumber = phone;
	}

	public void pay() {

	}
}
