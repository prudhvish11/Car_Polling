package ABC;
import java.util.*;
import java.time.*;
public class PoolDetails {

	String name;
	LocalDate date;
	String carNo;
	int Amount;
	String pickup;
	String destination;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNO) {
		this.carNo = carNO;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public PoolDetails(String name, LocalDate date, String carNo, int amount, String pickup, String destination) {
		super();
		this.name = name;
		this.date = date;
		this.carNo = carNo;
		Amount = amount;
		this.pickup = pickup;
		this.destination = destination;
	}
	
	
	
	
}