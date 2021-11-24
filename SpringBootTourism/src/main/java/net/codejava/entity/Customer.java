package net.codejava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String phoneno;
	
	private String email;
	
	private String address;
	
	private String member;
	
	private String modeofvehicle;
	
	private String date;
	
	private Long packageno;
	
	
	
	public Customer() {
		
	}

	

	public Customer(Long id, String name, String phoneno, String email, String address, String member,
			String modeofvehicle, String date, Long packageno) {
		super();
		this.id = id;
		this.name = name;
		this.phoneno = phoneno;
		this.email = email;
		this.address = address;
		this.member = member;
		this.modeofvehicle = modeofvehicle;
		this.date = date;
		this.packageno = packageno;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getModeofvehicle() {
		return modeofvehicle;
	}

	public void setModeofvehicle(String modeofvehicle) {
		this.modeofvehicle = modeofvehicle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getPackageno() {
		return packageno;
	}

	public void setPackageno(Long packageno) {
		this.packageno = packageno;
	}

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phoneno=" + phoneno + ", email=" + email + ", address="
				+ address + ", member=" + member + ", modeofvehicle=" + modeofvehicle + ", date=" + date
				+ ", packageno=" + packageno + "]";
	}

	
	

}
