package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import events.Reservation;

public class Car {

	private String registrationNumber;
	private Brand brand;
	private Model model;
	private String color;
	private Chassis chassis;
	private int km;

	private List<Reservation> reservations;

	public Car(String registrationNumber, Brand brand, Model model, String color, Chassis chassis, int km) {

		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.chassis = chassis;
		this.km = km;
		reservations = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Car [registrationNumber=" + registrationNumber + ", brand=" + brand + ", model=" + model + ", color="
				+ color + ", chassis=" + chassis + ", km=" + km + ", available=" + available
				+ ", getRegistrationNumber()=" + getRegistrationNumber() + ", getBrand()=" + getBrand()
				+ ", getModel()=" + getModel() + ", getColor()=" + getColor() + ", getChassis()=" + getChassis()
				+ ", getKm()=" + getKm() + ", getAvailable()=" + getAvailable() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Chassis getChassis() {
		return chassis;
	}

	public void setChassis(Chassis chassis) {
		this.chassis = chassis;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public List<Reservation> getAvailable() {
		return available;
	}

	public void setAvailable(List<Reservation> available) {
		this.available = available;
	}

	public boolean erLedig(LocalDateTime startDate, LocalDateTime endDate) {

		for (Reservation r : reservations) {
			if (startDate.isAfter(r.getRentalDate()) && startDate.isBefore(r.getSluttUtleie())) {
				return false;
			} else if (sluttDato.isAfter(r.getStartUtleie()) && sluttDato.isBefore(r.getSluttUtleie())) {
				return false;
			} else if (startDato.isBefore(r.getStartUtleie()) && sluttDato.isAfter(r.getSluttUtleie())) {
				return false;
			}
		}

		return true;
	};

}
