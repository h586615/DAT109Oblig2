package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import events.Reservation;

public class Car {

	private String registrationNumber;
	private Brand brand;
	private Model model;
	private String color;
	private Chassis chassis;
	private int km;
	private int price;

	private List<Reservation> reservations;

	public Car(String registrationNumber, Brand brand, Model model, String color, Chassis chassis, int km, int price) {

		this.registrationNumber = registrationNumber;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.chassis = chassis;
		this.km = km;
		this.price = price;
		reservations = new ArrayList<>();
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		if (reservations.contains(reservation)) {
			reservations.remove(reservation);
		}
	}

	public List<Car> ledigeBiler(List<Car> biler, Date nyFraDato, Date nyTilDato) {

		List<Car> ledigeBiler = new ArrayList<>();

		for (int i = 0; i < biler.size(); i++) { // start outer for loop

			boolean erLedig = true;
			
			List<Reservation> reservasjoner = biler.get(i).getReservations();

			for (int j = 0; j < reservasjoner.size(); j++) { // start inner for loop
				Reservation reservasjon = reservasjoner.get(j);

				if ((reservasjon.getReturnDate().after(nyFraDato)) && (reservasjon.getReturnDate().before(nyTilDato))) {// if
																														// statement
																														// 1:
																														// sjekke
																														// om
																														// reservasjonens
																														// returnDate
																														// er
																														// mellom
																														// nyFraDato
																														// og
																														// ny
																														// TilDato
					erLedig = false;
				}

				else if ((reservasjon.getRentalDate().after(nyFraDato))
						&& (reservasjon.getRentalDate().before(nyTilDato))) {// if statement 2: sjekke om reservasjonens
																				// rentalDate er mellom nyFraDato og ny
																				// Tildato
					erLedig = false;
				}

				else if (((nyFraDato.after(reservasjon.getRentalDate())
						&& nyFraDato.before(reservasjon.getReturnDate()))
						&& (nyTilDato.after(reservasjon.getRentalDate())
								&& nyTilDato.before(reservasjon.getReturnDate())))) {// if statement 3: sjekke om
																						// nyFraDato og nyTilDato begge
																						// er mellom rentalDate og
																						// returnDate
					erLedig = false;
				}
			} // end inner for loop

			if (erLedig) { // start if statement 2
				ledigeBiler.add(biler.get(i));
			} // end if statement 2
		} // end outer for loop
		
		return ledigeBiler;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the chassis
	 */
	public Chassis getChassis() {
		return chassis;
	}

	/**
	 * @param chassis the chassis to set
	 */
	public void setChassis(Chassis chassis) {
		this.chassis = chassis;
	}

	/**
	 * @return the km
	 */
	public int getKm() {
		return km;
	}

	/**
	 * @param km the km to set
	 */
	public void setKm(int km) {
		this.km = km;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the reservations
	 */
	public List<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Car [registrationNumber=" + registrationNumber + ", brand=" + brand + ", model=" + model + ", color="
				+ color + ", chassis=" + chassis + ", km=" + km + ", price=" + price + "]";
	}

}
