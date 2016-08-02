package jp.co.tottori.entity;

import java.util.Calendar;
import java.util.Date;

public class BlackList {

	private String user_id;
	private String user_name;
	private String address;
	private String mail;
	private String phoneNumber;
	private String book_name;
	private int isbn;
	private Date rental_time;
	private Date return_time;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public Date getRental_time() {
		return rental_time;
	}
	public void setRental_time(Date rental_time1) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(rental_time1);
		Date rental_time = new java.sql.Date(cal.getTimeInMillis());
		this.rental_time = rental_time;
	}
	public Date getReturn_time() {
		return return_time;
	}

	public void setReturn_time(Date return_time1) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(return_time1);
		cal.add(Calendar.DATE, 14);
		Date return_time = new java.sql.Date(cal.getTimeInMillis());
		this.return_time = return_time;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
