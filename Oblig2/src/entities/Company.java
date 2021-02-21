package entities;

import java.util.ArrayList;
import java.util.List;

import events.Reservation;
import main.CarFactory;

public class Company {

	private String name;
	private int telephoneNumber;
	private CarFactory factory;

	private List<Office> allOffices = new ArrayList<>();
	private List<Car> allCars = new ArrayList<>();
	private List<Customer> customers;

	public Company(String name, int telephoneNumber) {

		this.name = name;
		this.telephoneNumber = telephoneNumber;

		factory = new CarFactory();
		factory.setup();

		allOffices = factory.getOffices();
		allCars = factory.getAllCars();
		customers = new ArrayList<>();
	}

	public void addToAllCars(Car car) {
		allCars.add(car);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public Customer addCustomer(String surname, String lastname, String address, int zipCode, 
			String area, int phoneNumber) {
		Customer customer = new Customer(surname, lastname, new Address(address, zipCode, area), phoneNumber,
				new Reservation());
		
		return customer;
	}

	public Reservation findReservation(String creditCardNumber) {
		
		Reservation reservation = null;

		for (Customer c : customers) {
			if (c.getReservation().getCreditCardNumber().equals(creditCardNumber)) {
				reservation = c.getReservation();
				System.out.println(c.getReservation());
			}
		}
		return reservation;
	}
	
	public void returnCar(Customer customer) {
		for(Customer c : customers) {
			if(c.equals(customer)) {
				c.setReservation(null);
				System.out.println("The rental car was successfully delivered");
			}
		}
	}

	public List<Car> cityCars(int a) {

		List<Car> cityCars = new ArrayList<>();

		if (a == 1) {

			cityCars = allOffices.get(0).getCars();
		}

		else {
			cityCars = allOffices.get(1).getCars();

		}
		return cityCars;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public List<Car> getOsloCars() {
		List<Car> osloCars = new ArrayList<>();
		osloCars = factory.getOsloCars();
		return osloCars;
	}

	public List<Car> getLongyearsCars() {
		List<Car> longyearsCars = new ArrayList<>();
		longyearsCars = factory.getLongyearCars();
		return longyearsCars;
	}

	public List<Office> getAllOffices() {
		return allOffices;
	}

	public void setAllOffices(List<Office> allOffices) {
		this.allOffices = allOffices;
	}

	public List<Car> getAllCars() {
		allCars = factory.getAllCars();
		return allCars;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void setAllCars(List<Car> allCars) {
		this.allCars = allCars;
	}

}
