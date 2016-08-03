package jp.co.tottori.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MypageRentalDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private static List<MypageRentalDto> myPageRentalDto;
	private String userId;
	private String userName;
	private String bookName;
	private String authorName;
	private int isbn;
	private int reserve_id;
	private Date rentalTime;
	private Date returnTime;

	public static  List<MypageRentalDto> getMypageRentalDto() {
		if (myPageRentalDto == null) {
			myPageRentalDto = new ArrayList<MypageRentalDto>();
		}
		return myPageRentalDto;
	}
	public static void setMypageRentalDto(List<MypageRentalDto> DtoList) {
		myPageRentalDto = DtoList;
	}

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
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}
}
