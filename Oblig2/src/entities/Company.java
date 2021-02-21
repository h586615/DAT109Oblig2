package entities;

import java.util.ArrayList;
import java.util.List;

import events.Reservation;
import main.Temporary;

public class Company {

	private String name;
	private int telephoneNumber;
	private String addresse;

	private List<Office> allOffices;
	private Temporary temp;
	private List<Car> allCars;
	private List<Customer> customers;

	public Company(String name, int telephoneNumber, String addresse) {
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.addresse = addresse;
		allOffices = new ArrayList<>();
		customers = new ArrayList<>();
	}

	public void allOffices() {
		allOffices = temp.getAllOffices();
		for (int i = 0; i < allOffices.size(); i++) {
			System.out.println(allOffices.get(i));
		}
	}
	public List<Car> getAllCars() {
		return allCars;	
	}
	public void addToAllCars(Car car){
		allCars.add(car);
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void findReservation(String creditCardNumber) {
		
		for(Customer c : customers) {
			if(c.getReservation().getCreditCardNumber().equals(creditCardNumber)) {
				System.out.println(c.getReservation());
			}
		}	
	}

//	public void checkAvailable(Address rentalPlace, Date rentalDate, Date returnDate) {
//
//	}

}
