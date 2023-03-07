package com.cestar.model;

import java.sql.Date;

public class Client {

		
	private int id ;
	private String name ;
	private String contact ;
	private String itemShipped ;
	private Date date_received ;
	private Date date_shipped ;
	
	
	
	
	public Client(int id, String name, String contact, String itemShipped, Date date_received, Date date_shipped) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.itemShipped = itemShipped;
		this.date_received = date_received;
		this.date_shipped = date_shipped;
	}
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getItemShipped() {
		return itemShipped;
	}
	public void setItemShipped(String itemShipped) {
		this.itemShipped = itemShipped;
	}
	public Date getDate_received() {
		return date_received;
	}
	public void setDate_received(Date date_received) {
		this.date_received = date_received;
	}
	public Date getDate_shipped() {
		return date_shipped;
	}
	public void setDate_shipped(Date date_shipped) {
		this.date_shipped = date_shipped;
	}
	
	
}
