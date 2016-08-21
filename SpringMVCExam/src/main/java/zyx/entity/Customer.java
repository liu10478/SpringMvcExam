package zyx.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
	private int customer_id;
	private int store_id;
	@NotEmpty
	private String first_name;
	@NotEmpty
	private String last_name;
	@Email
	private String email;
	private int address_id;
	private boolean active;
	private java.util.Date create_date;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date last_update;
	private Address address;
	private Store store;
	
	
	
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public java.util.Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(java.util.Date create_date) {
		this.create_date = create_date;
	}
	public java.util.Date getLast_update() {
		return last_update;
	}
	public void setLast_update(java.util.Date last_update) {
		this.last_update = last_update;
	}
	public Customer(String first_name) {
		super();
		this.first_name = first_name;
	}
	
	public Customer(int customer_id, String first_name) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
	}
	
	
	public Customer(int customer_id, String first_name, String last_name) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	
	
	
	public Customer(String first_name, String last_name, String email, Address address, Store store) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.address = address;
		this.store = store;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", store_id=" + store_id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", email=" + email + ", address_id=" + address_id + ", active=" + active
				+ ", create_date=" + create_date + ", last_update=" + last_update + ", address=" + address + ", store="
				+ store + "]";
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
}
