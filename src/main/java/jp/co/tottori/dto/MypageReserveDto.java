package jp.co.tottori.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MypageReserveDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private static List<MypageReserveDto> myPageReserveDto;
	private int reserve_id;
	private String user_id;
	private String user_name;
	private String book_name;
	private int isbn;
	private Date reserve_time;

	public static  List<MypageReserveDto> getMypageReserveDto() {
		if (myPageReserveDto == null) {
			myPageReserveDto = new ArrayList<MypageReserveDto>();
		}
		return myPageReserveDto;
	}
	public static void setMypageReserveDto(List<MypageReserveDto> DtoList) {
		myPageReserveDto = DtoList;
	}

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
	public Date getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(Date reserve_time) {
		this.reserve_time = reserve_time;
	}
	public int getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}

}
