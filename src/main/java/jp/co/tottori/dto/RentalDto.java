package jp.co.tottori.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class RentalDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private static RentalDto rentalDto;
	private int rentalId;
	private String userId;
	private String userName;
	private int[] isbn;
	private int UseIsbn;
	private int libraryId;
	private Date rentalTime;
	private String date;

	public static RentalDto getRentalDto() {
		if (rentalDto == null) {
			rentalDto = new RentalDto();
		}
		return rentalDto;
	}
	public static void setRentalDto(RentalDto Dto) {
		rentalDto = Dto;
	}

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
	public int getUseIsbn() {
		return UseIsbn;
	}
	public void setUseIsbn(int useIsbn) {
		UseIsbn = useIsbn;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}