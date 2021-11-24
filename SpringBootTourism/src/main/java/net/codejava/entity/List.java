package net.codejava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="list")
public class List {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String place;
	
	private String description;
	
	private String areas;
	
	private String hotel;
	
	private Long noofdays;
	
	private String amount;
	
	

	public List() {
		
	}

   

	


	public List(Long id, String place, String description, String areas, String hotel, Long noofdays,
			String amount) {
		super();
		this.id = id;
		this.place = place;
		this.description = description;
		this.areas = areas;
		this.hotel = hotel;
		this.noofdays = noofdays;
		this.amount = amount;
	}






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	

	public Long getNoofdays() {
		return noofdays;
	}



	public void setNoofdays(Long noofdays) {
		this.noofdays = noofdays;
	}


	@Override
	public String toString() {
		return "List [id=" + id + ", place=" + place + ", description=" + description + ", areas=" + areas + ", hotel="
				+ hotel + ", noofdays=" + noofdays + ", amount=" + amount + "]";
	}

	
}
