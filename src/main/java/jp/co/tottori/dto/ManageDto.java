package jp.co.tottori.dto;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ManageDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private static ManageDto manageDto;
	private String loginId;
	private String password;
	private int libraryId;

	public static ManageDto getManageDto() {
		if (manageDto == null) {
			manageDto = new ManageDto();
		}
		return manageDto;
	}

	public static void setManageDto(ManageDto Dto) {
		manageDto = Dto;
	}

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
}