package jp.co.tottori.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MypageUserDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private static MypageUserDto myPageUserDto;
	private String user_id;
	private String user_name;
	private String address;
	private String mail;
	private String phoneNumber;
	private int library_id;
	private Date insert_time;
	private Date update_time;

	public static MypageUserDto getMypageUserDto() {
		if (myPageUserDto == null) {
			myPageUserDto = new MypageUserDto();
		}
		return myPageUserDto;
	}

	public static void setMypageUserDto(MypageUserDto Dto) {
		myPageUserDto = Dto;
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
	public int getLibrary_id() {
		return library_id;
	}
	public void setLibrary_id(int library_id) {
		this.library_id = library_id;
	}
	public Date getInsert_time() {
		return insert_time;
	}
	public void setInsert_time(Date insert_time) {
		this.insert_time = insert_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

}
