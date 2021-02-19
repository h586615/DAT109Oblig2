package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
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

	public void cityCars(Address a) {
		if (a.getArea().equals("Mogadishu")) {
			cars = temp.mogadishuCars();
		} else {
			cars = temp.pyongyangCars();
		}
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i));
		}

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
