package gui;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;


public class Tekstgrensesnitt
{

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
		
		System.out.println("Please enter the city you want to rent from 'Pyongyang' or 'Mogadishu'.");
		String city = sc.next();
		System.out.println("Please enter rental date, yyyy-MM-dd");
		String rentalDate = sc.next();
		System.out.println("Plase enter return date, yyyy-MM-dd");
		String returnDate = sc.next();
		
		
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
		System.out.println("Please enter the company that made the film.");
		String company = sc.next();
		System.out.println("Please enter the genre of the film.");
		String genreString = sc.next();
		Sjanger genre = Sjanger.findGenre(genreString);

		Film newFilm = new Film(0, year, producer, title, company, genre);
		System.out.println("Film successfully saved to the archive.");

		return newFilm;
		
	}
	
	
	
	
	

	public void printAvailableCars(List<Car> cars){
		for(Car c : cars) {
			System.out.println(c.toString());
		}
	}
	
	public void findAvailableCars() {
		
		ledigeBiler();
	}
	
	public void choseCar(Car car, int number) {
		
		
		
		
	}
	
	public Reservation readReservation()
	{
		System.out.println("Please enter the title of the film you want to add.");
		String title = sc.next();
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
		System.out.println("Please enter the company that made the film.");
		String company = sc.next();
		System.out.println("Please enter the genre of the film.");
		String genreString = sc.next();
		Sjanger genre = Sjanger.findGenre(genreString);

		Film newFilm = new Film(0, year, producer, title, company, genre);
		System.out.println("Film successfully saved to the archive.");

		return newFilm;
	}

	public void exit()
	{
		System.out.println("Shutting down...");
		System.exit(0);
	}
}
