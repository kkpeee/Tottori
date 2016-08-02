package jp.co.tottori.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty(message = "エラー：ログインIDを入力してください")
	@Size(min = 4, max = 8, message = "エラー：ログインIDは４桁以上８桁以下で入力してください")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
