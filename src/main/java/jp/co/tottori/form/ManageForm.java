package jp.co.tottori.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class ManageForm {
	@NotNull(message = "エラー：ログインIDを入力してください")
	@Min(value=1,message = "エラー：ログインIDは1以上で入力してください")
	@Max(value=999, message = "エラー：ログインIDは3桁以内で入力してください")
	private String loginId;
	@NotBlank(message = "エラー：パスワードを入力してください")
	@Size(min = 4, max = 16, message = "エラー：パスワードは4桁以上16桁以下で入力してください")
	private String password;
	private int libraryId;

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