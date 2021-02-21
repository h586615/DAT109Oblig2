package entities;

import java.util.Date;
import java.util.List;

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
	
	@Override
	public String toString() {
		return "[" + surname + ", " + lastname + ", address=" + address + ", phone="
		+ phoneNumber + "]";
	}
	

	/**
	 * customer make reservation
	 * @return the reservation
	 */
	public Reservation makeReservation(Office office, String creditCard, Car car, Date rentalDate, Date timeRental, 
			Date returnDate, Date timeReturn, int numberOfDays) {
		
		int carPrice = car.getPrice();
		int paymentSum = price(numberOfDays, carPrice);
		boolean payment = true;
		
		Reservation newReservation = new Reservation(office, creditCard, car, rentalDate, timeRental, 
				returnDate, timeReturn, numberOfDays, paymentSum, payment);
		
		return newReservation;
		
	}
	
	/**
	 * calculate the price to rent a car
	 * @param days, number of rental days
	 * @param carPrice
	 * @return sum
	 */
	public int price(int days, int carPrice) {
		int sum = days * carPrice; 
		return sum;
	}
	
}
