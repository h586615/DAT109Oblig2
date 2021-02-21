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
	private Date timeRental;
	private Date returnDate;
	private Date timeReturn;
	private int numberOfDays;
	private int sum; 
	private boolean payment;

	public Reservation() {
		
	}
	public Reservation(Office office, String creditCardNumber, Car car, Date rentalDate, Date timeRental,
			Date returnDate, Date timeReturn, int numberOfDays, int sum, boolean payment) {

		this.office = office;
		this.creditCardNumber = creditCardNumber;
		this.car = car;
		this.rentalDate = rentalDate;
		this.timeRental = timeRental;
		this.returnDate = returnDate;
		this.timeReturn = timeReturn;
		this.numberOfDays = numberOfDays;
		this.sum = sum;
		this.payment = payment;
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