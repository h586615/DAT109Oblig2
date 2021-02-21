package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Address;
import entities.Car;
import entities.Company;
import entities.Customer;
import entities.Office;
import events.Reservation;


public class Tekstgrensesnitt
{
	Car car;
	Customer customer;
	Company company;
	Office office;
	Scanner sc;
	
	public Tekstgrensesnitt()
	{
		sc = new Scanner(System.in);
		sc.useDelimiter(System.lineSeparator());
	}

	public int showMainMenu()
	{
		int choice = 0;

		System.out.println("Welcome to Abu Tallah's Rental Company");
		System.out.println("1: Search for available cars");
		System.out.println("2: Search for reservation");
		System.out.println("3: Return car");
		System.out.println("4: Exit the program.");

		String input = sc.next();

		try
		{
			choice = Integer.parseInt(input);
			return choice;
		} catch (NumberFormatException e)
		{
			System.out.println("Error: The input is not a valid choice");
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * the customer type in which city, rental/return date and is given a list of all the available cars
	 */
	public void searchAndMakeReservation() {
		
		Car rentalCar = null;
		Reservation reservation = null;
		
		System.out.println("Please enter the city you want to rent from '1: Longyearbyen' or '2: Oslo'.");
		int city = Integer.parseInt(sc.next());
		
		System.out.println("Please enter rental year");
        String year = sc.next();
        
        System.out.println("Please enter rental month");
        String month = sc.next();
        
        System.out.println("Please enter rental day number");
        String day = sc.next();
        
        Date rentalDate = new Date(year, month, day, 07, 00);
        
        System.out.println("Please enter return year");
        String returnYear = sc.next();
        
        System.out.println("Please enter return month");
        String returnMonth = sc.next();
        
        System.out.println("Please enter return day number");
        String returnDay = sc.next();
        
        Date returnDate = new Date(returnYear, returnMonth, returnDay, 22, 00);
        
        int numberOfDays = 0; //need to find number of days 
        
		List<Car> cars = office.cityCars(city);
		
		int numberOfCars = printAvailableCars(car.ledigeBiler(cars, rentalDate, returnDate));
	  
		
		rentalCar = pickCar(numberOfCars, cars);
		
		Customer newCustomer = registerCustomer();
		
		reservation = makeReservation(rentalCar,rentalDate, returnDate, numberOfDays);
		
		updateReservationToCostumer(newCustomer, reservation);
		
	}
	
	/**
	 * 
	 * @param number of available cars
	 * @param cars, list of cars
	 * @return the chosen car
	 */
	public Car pickCar(int number, List<Car> cars) {
	
		Car car = null;
		
		System.out.println("Chose the car you want to rent, type '0' to exit the service");
		
		int choice = Integer.parseInt(sc.next());
		
		if(choice == 0) {
			exit();
		} 
		if(choice >= 1 && choice <= number) {
			car = cars.get(choice-1);
		}
		
		return car;
		
	}
	
	/**
	 * when customer makes a reservation, the reservation object in costumer gets updated 
	 * add the customer to the costumer list in Company
	 * @param customer to be updated
	 * @param reservation to be added
	 */
	public void updateReservationToCostumer(Customer customer, Reservation reservation) {
		
		Customer updatedCustomer = customer;
		
		updatedCustomer.setReservation(reservation);
		
		company.addCustomer(updatedCustomer);
	}
	
	/**
	 * ask customer to type in credit card number, and if the customer wants to pay the given 'sum'
	 * @return the reservation that was made 
	 */
	public Reservation makeReservation(Car car, Date rentalDate, Date returnDate, int numberOfDays) {
		
		Reservation reservation = null; 
		
		System.out.println("To make a reservation type in your credit card number");
		
		String creditcardNumber = sc.next();
		
		int price = customer.price(numberOfDays, car.getPrice());
		
		System.out.println("Your sum is: " + price + "\n" + "Type '1' to confirm payment, type '0' to exit");
		int number = Integer.parseInt(sc.next());
		
		if(number == 0) {
			exit();
		}
		if(number == 1) {
			System.out.println("Your payment was successful");
			reservation = customer.makeReservation(creditcardNumber, car, rentalDate, returnDate, numberOfDays, price);
		}
		
		return reservation;
	}
	
	/**
	 * register a customer with help from Scanner 
	 * @return the Customer 
	 */
	public Customer registerCustomer() {
		
		System.out.println("To confirm the reservation you need to sign up as a customer");
		System.out.println("Please enter your surname");
		String surname = sc.next(); 
		System.out.println("Please enter your lastname");
		String lastname = sc.next(); 
		System.out.println("Please enter your address");
		String address = sc.next();
		System.out.println("Please enter your zip code");
		int zipCode = Integer.parseInt(sc.next());
		System.out.println("Please enter your area");
		String area = sc.next();
		
		System.out.println("Please enter your phone number");
		String phone = sc.next();
		
		while(!checkPhone(phone)) {
			System.out.println("Phone number can only contain digits, please enter again");
			phone = sc.next();
		}
		
		int phoneNumber = Integer.parseInt(phone);
		
		Customer customer = new Customer(surname, lastname, new Address(address, zipCode, area), phoneNumber, new Reservation());
		
		return customer;
	}
	
	
	/**
	 * check if a phone number only contains digits
	 * @param phone number
	 * @return true or false 
	 */
	public boolean checkPhone(String phone) {
		if(phone.matches("[0-9]+") && phone.length() == 7) {
			return true;
		}
		return false;
	}
	
	public void returnCar() {
		
		
		
	}
	
	/**
	 * print out reservation 
	 */
	public void searchForReservation() {
		
		System.out.println("Please enter your credit card number");
		String creditCardNumber = sc.next();
		
		company.findReservation(creditCardNumber);
		
	}

	public int printAvailableCars(List<Car> cars){
		int i = 0;
		for(Car c : cars) {
			i++;
			System.out.println(i + " " + c.toString());
		}
		
		return i;
	}

	public void exit()
	{
		System.out.println("Shutting down...");
		System.exit(0);
	}
}
