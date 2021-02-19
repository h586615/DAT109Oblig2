package main;

import java.util.ArrayList;
import java.util.List;

import entities.Address;
import entities.Brand;
import entities.Car;
import entities.Chassis;
import entities.Model;
import entities.Office;

public class Temporary {

	public List<Car> companyCars() {
		List<Car> allCars = new ArrayList<>();

		Car c1 = new Car("EL47015", Brand.VW, Model.E_UP, "grey", Chassis.A, 80000);
		Car c2 = new Car("RK98253", Brand.TESLA, Model.S, "black", Chassis.B, 100000);
		Car c3 = new Car("EL47015", Brand.AUDI, Model.E_UP, "grey", Chassis.A, 80000);
		Car c4 = new Car("EK68530", Brand.NISSAN, Model.LEAF, "grey", Chassis.A, 80000);
//		Car c5 = new Car("EL47015", Brand.BMW, Model.E_UP, "grey", Chassis.A, 80000);
//		Car c6 = new Car("EL47015", Brand.TESLA, Model.E_UP, "grey", Chassis.A, 80000);
//		Car c7 = new Car("EL47015", Brand.VW, Model.E_UP, "grey", Chassis.A, 80000);
//		Car c8 = new Car("EL47015", Brand.AUDI, Model.E_UP, "grey", Chassis.A, 80000);
//		Car c9 = new Car("EL47015", Brand.BMW, Model.E_UP, "grey", Chassis.A, 80000);
//		Car c10 = new Car("EL47015", Brand.VW, Model.E_UP, "grey", Chassis.A, 80000);

		allCars.add(c1);
		allCars.add(c2);
		allCars.add(c3);
		allCars.add(c4);
//		cars.add(c5);
//		cars.add(c6);
//		cars.add(c7);
//		cars.add(c8);
//		cars.add(c9);
//		cars.add(c10);
		return allCars;

	}
	
	public List<Office> getAllOffices() {
		List<Office> offices = new ArrayList<>();

		Office c1 = new Office(1, new Address("Haakonsgate 32", 5010, "Bergen"), 51390477);
		Office c2 = new Office(2, new Address("Helmerz Strandgate 50", 1259, "Oslo"), 51490377);

		offices.add(c1);
		offices.add(c2);

		return offices;
	}

	public static void main(String[] args) {

	}
}
