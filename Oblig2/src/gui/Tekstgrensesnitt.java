package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Address;
import entities.Car;
import entities.Customer;
import entities.Office;
import events.Reservation;


public class Tekstgrensesnitt
{
	Car car;
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
		System.out.println("2: Search for reservations.");
		System.out.println("3: Exit the program.");

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
	public void searchForAvailableCars() {
		
		Date rentalDate = null;
		Date returnDate = null;
		Car rentalCar = null;
		
		System.out.println("Please enter the city you want to rent from '1: Longyearbyen' or '2: Oslo'.");
		int city = Integer.parseInt(sc.next());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
		
		System.out.println("Please enter rental date and time, dd-M-yyyy hh:mm");
		String rentald = sc.next();
		
		try {
			rentalDate = sdf.parse(rentald);

		} catch (ParseException e) {
	
			e.printStackTrace();
		}
		
		System.out.println("Plase enter return date and time, dd-M-yyyy hh:mm");
		String returnd = sc.next();
		try {
			returnDate = sdf.parse(returnd);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		List<Car> cars = office.cityCars(city);
		
		int numberOfCars = printAvailableCars(car.ledigeBiler(cars, rentalDate, returnDate));
	  
		
		rentalCar = pickCar(numberOfCars, cars);
		
		Customer customer = registerCustomer();
		
		
		
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
			System.out.println("Goodbye!");
			System.exit(0);
		} 
		if(choice >= 1 && choice <= number) {
			car = cars.get(choice-1);
		}
		
		return car;
		
	}
	
	public Reservation makeReservation() {
		
		
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

	public void searchForReservations() {
		
		System.out.println("Please enter the surname to find the reservation");
		String surname = sc.next();
		System.out.println("Please enter the producer of the film you want to add.");
		String producer = sc.next();
		int year;
		while (true)
		{
			System.out.println("Please enter the year the movie was released.");

			String input = sc.next();
			try
			{
				year = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e)
			{
				continue;
			}
		}
		
	}

	public int printAvailableCars(List<Car> cars){
		int i = 0;
		for(Car c : cars) {
			i++;
			System.out.println(i + c.toString());
		}
		
		return i;
	}

	public void exit()
	{
		System.out.println("Shutting down...");
		System.exit(0);
	}
}
