package jp.co.tottori.form;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RentalForm {

	private int rentalId;
	@NotEmpty(message = "エラー：ログインIDを入力してください")
	@Size(min = 4, max = 8, message = "エラー：ログインIDは４桁以上８桁以下で入力してください")
	private String userId;
	@NotEmpty(message = "エラー：ISBNを入力してください")
	private int[] isbn;
	private int libraryId;
	private Date rentalTime;

	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int[] getIsbn() {
		return isbn;
	}
	public void setIsbn(int[] isbn) {
		this.isbn = isbn;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
}