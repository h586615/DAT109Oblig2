package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Address;
import entities.Brand;
import entities.Car;
import entities.Chassis;
import entities.Company;
import entities.Customer;
import entities.Model;
import events.Reservation;
import gui.Tekstgrensesnitt;


class CarRentalTest {
	

	private Tekstgrensesnitt ui;
	Company company;
	Reservation r1;
	Reservation r2;

	@BeforeEach
	void setUp() {
		
		company = new Company("Abu Tallah's Rental Company", 45638928);
		ui = new Tekstgrensesnitt();
		
		Car car1 = new Car("EK98253", Brand.TESLA, Model.S, "black", Chassis.B, 100000, 2500);
		Car car2 = new Car("EK68530", Brand.NISSAN, Model.LEAF, "grey", Chassis.A, 80000, 800);
		
		int price1 = ui.price(3, car1.getPrice());
		int price2 = ui.price(6, car2.getPrice());
		
		Customer c1 = new Customer("Emilie", "Hinna", new Address("Sverres gate 32", 5010, "Bergen"), 47520188, new Reservation());
		Customer c2 = new Customer("Fun Light", "Uten sukker", new Address("Safthylle 1", 6793, "Væske"), 67946302, new Reservation());
		
		r1 = new Reservation("123456789", c1, car1, new Date(2021, 3, 1, 07, 00), new Date(2021, 3, 4, 22, 00), 3, price1, true);
		c1.setReservation(r1);
		
		r2 = new Reservation("232367893", c2, car2, new Date(2021, 2, 1, 07, 00), new Date(2021, 2, 7, 22, 00), 6, price2, true);
		c2.setReservation(r2);
		
		company.addCustomer(c1);
		company.addCustomer(c2);
		
		company.addToAllCars(car1);
		company.addToAllCars(car2);
	}
	
	@Test
	void availableCarsTest() {
		
	}

	
	@Test
	void findReservationTest() {
		
		Reservation reservation = null;
		
		reservation = company.findReservation("123456789");
		
		assertEquals(r1, reservation);
	}
	
	@Test
	void priceTest() {
		
		int days = 3; 
		int price = 1000;
		
		assertEquals(3000, ui.price(days, price));
		
	}
	
	public Car pickCar(int number, List<Car> cars) {

		Car car = null;

		System.out.println("Chose the car you want to rent, type '0' to exit the service");

		int choice = Integer.parseInt(sc.next());

		if (choice == 0) {
			exit();
		}
		if (choice >= 1 && choice <= number) {
			car = cars.get(choice - 1);
		}

		return car;

	}
	
	@Test
	void pickCarTest() {
		
		pickCar
		
	}
	
	@Test
	void searchForReservation() {
		
	}
	

}
