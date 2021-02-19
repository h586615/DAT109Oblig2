package entities;

import java.time.LocalDateTime;
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
				+ color + ", chassis=" + chassis + ", km=" + km + ", reservations=" + reservations + "]";
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

	public List<Car> ledigeBiler(List<Car> biler, Date nyFraDato, Date nyTilDato) {
	    
	    List<Car> ledigeBiler =  new ArrayList<>();
	    
	    for (int i = 0; i < biler.size(); i++) { // start outer for loop

	        boolean erLedig = true;
	        List<Reservation> reservasjoner = biler.get(i).getReservations();

	        for (int j = 0; j < reservasjoner.size(); j++) { //start inner for loop
	        Reservation reservasjon = reservasjoner.get(j);
	          
	            if( ( reservasjon.getReturnDate().after(nyFraDato) ) && ( reservasjon.getReturnDate().before(nyTilDato) ) ) {//if statement 1: sjekke om reservasjonens returnDate er mellom nyFraDato og ny TilDato
	                erLedig = false;
	            } 
	            
	            else if ( (reservasjon.getRentalDate().after(nyFraDato)) && (reservasjon.getRentalDate().before(nyTilDato)) ) {// if statement 2: sjekke om reservasjonens rentalDate er mellom nyFraDato og ny Tildato
	                erLedig = false;
	            } 
	            
	            else if( ( (nyFraDato.after(reservasjon.getRentalDate()) && nyFraDato.before(reservasjon.getReturnDate())) 
	                    && (nyTilDato.after(reservasjon.getRentalDate()) && nyTilDato.before(reservasjon.getReturnDate())) ) ) {//if statement 3: sjekke om nyFraDato og nyTilDato begge er mellom rentalDate og returnDate
	                erLedig = false;
	            }
	        } //end inner for loop

	        if (erLedig) { // start if statement 2
	          ledigeBiler.add(biler.get(i)); 
	        } //end if statement 2
	    } //end outer for loop

	    return ledigeBiler;
	}


}
