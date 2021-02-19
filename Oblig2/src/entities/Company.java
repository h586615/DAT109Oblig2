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
	private List<Car> cars;

	public Company(String name, int telephoneNumber, String addresse) {
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.addresse = addresse;
	}

	public void allOffices() {
		allOffices = temp.getAllOffices();
		for (int i = 0; i < allOffices.size(); i++) {
			System.out.println(allOffices.get(i));
		}
	}



//	public void checkAvailable(Address rentalPlace, Date rentalDate, Date returnDate) {
//
//	}

}
