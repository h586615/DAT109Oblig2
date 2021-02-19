package entities;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Office {


	private int officeNumber;
	private Address address;
	private int telephoneNumber;


	public Office(int officeNumber, Address address, int telephoneNumber) {
				this.officeNumber = officeNumber;
				this.address = address;
				this.telephoneNumber = telephoneNumber;
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
