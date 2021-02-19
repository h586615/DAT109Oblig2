package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.Temporary;

public class Office {

	private int officeNumber;
	private Address address;
	private int telephoneNumber;
	private Temporary temp;
	private List<Car> cars;

	public Office(int officeNumber, Address address, int telephoneNumber) {
		this.officeNumber = officeNumber;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}

	public List<Car> cityCars(int a) {
		cars = new ArrayList<>();
		if (a == 1) {
			cars = temp.longyearCars();

		} else {
			cars = temp.osloCars();
		}
		return cars;

	}

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

}
