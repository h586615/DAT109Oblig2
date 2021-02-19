package events;

import java.time.LocalTime;
import java.util.Date;

import entities.Car;
import entities.Customer;
import entities.Office;

public class Reservation {

	private Office office;
	private String creditCardNumber;
	private Car car;
	private Date rentalDate;
	private Date timeAtRental;
	private Date returnDate;
	private int numberOfDays;

	public Reservation(Office office, String creditCardNumber, Car car, Date rentalDate, Date timeAtRental,
			Date returnDate, int numberOfDays) {

		this.office = office;
		this.creditCardNumber = creditCardNumber;
		this.car = car;
		this.rentalDate = rentalDate;
		this.timeAtRental = timeAtRental;
		this.returnDate = returnDate;
		this.numberOfDays = numberOfDays;
	}

	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}

	/**
	 * @return the rentalDate
	 */
	public Date getRentalDate() {
		return rentalDate;
	}

	/**
	 * @param rentalDate the rentalDate to set
	 */
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	/**
	 * @return the timeAtRental
	 */
	public Date getTimeAtRental() {
		return timeAtRental;
	}

	/**
	 * @param timeAtRental the timeAtRental to set
	 */
	public void setTimeAtRental(Date timeAtRental) {
		this.timeAtRental = timeAtRental;
	}

	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the numberOfDays
	 */
	public int getNumberOfDays() {
		return numberOfDays;
	}

	/**
	 * @param numberOfDays the numberOfDays to set
	 */
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

}