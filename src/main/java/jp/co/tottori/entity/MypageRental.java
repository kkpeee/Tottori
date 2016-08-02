package jp.co.tottori.entity;

import java.util.Calendar;
import java.util.Date;

public class MypageRental {

	private String userId;
	private String userName;
	private String bookName;
	private String authorName;
	private int isbn;
	private Date rentalTime;
	private Date returnTime;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rental_time1) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(rental_time1);
		Date rental_time = new java.sql.Date(cal.getTimeInMillis());

		this.rentalTime = rental_time;
	}
	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date return_time1) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(return_time1);
		cal.add(Calendar.DATE, 14);
		Date return_time = new java.sql.Date(cal.getTimeInMillis());
		this.returnTime = return_time;
	}
}
