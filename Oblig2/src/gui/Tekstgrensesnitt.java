package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Car;
import entities.Office;


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
	
	public void searchForAvailableCars() {
		
		Date rentalDate = null;
		Date returnDate = null;
		
		System.out.println("Please enter the city you want to rent from '1: Pyongyang' or '2: Mogadishu'.");
		int city = Integer.parseInt(sc.next());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		
		System.out.println("Please enter rental date and time, dd-M-yyyy hh:mm:ss");
		String rentald = sc.next();
		
		try {
			rentalDate = sdf.parse(rentald);

		} catch (ParseException e) {
	
			e.printStackTrace();
		}
		
		System.out.println("Plase enter return date and time, dd-M-yyyy hh:mm:ss");
		String returnd = sc.next();
		try {
			returnDate = sdf.parse(returnd);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		printAvailableCars(car.ledigeBiler(office.cityCars(city), rentalDate, returnDate));
		
	   
	  
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

	public void printAvailableCars(List<Car> cars){
		for(Car c : cars) {
			System.out.println(c.toString());
		}
	}

	public void exit()
	{
		System.out.println("Shutting down...");
		System.exit(0);
	}
}
