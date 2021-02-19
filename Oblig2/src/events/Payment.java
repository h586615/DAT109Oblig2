package events;

	public class Payment {


	private int paymentId; 
	
	private int reservationId;
	
	private int price;


	
	public Payment(int pid, int rid, int price) {
		this.paymentId = pid;
		this.reservationId = rid;
		this.price = price;
	}
	
}
