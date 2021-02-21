package entities;

import java.util.Date;

import events.Reservation;

public class Customer {

	private String lastname;
	private String surname;
	private Address address;
	private int phoneNumber;
	private Reservation reservation;

	public Customer(String surname, String lastname, Address address, int phone, Reservation reservation) {
		this.surname = surname;
		this.lastname = lastname;
		this.address = address;
		this.phoneNumber = phone;
		this.reservation = reservation;
	}

	/**
	 * customer makes a reservation
	 * 
	 * @return the reservation
	 */
	public Reservation makeReservation(String creditCard, Car car, Date rentalDate, Date returnDate, int numberOfDays,
			int sum) {

		boolean payment = true;

		Reservation newReservation = new Reservation(creditCard, car, rentalDate, returnDate, numberOfDays, sum,
				payment);

		return newReservation;

	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "[" + surname + ", " + lastname + ", address=" + address + ", phone=" + phoneNumber + "]";
	}

}
