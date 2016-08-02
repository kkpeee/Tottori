package jp.co.tottori.form;

import javax.validation.constraints.Pattern;

public class ReserveForm {
	@Pattern(regexp = "[a-zA-Z0-9]*", message="ユーザーIDは半角英数字で入力してください" )
	private String userId;
	private int[] reserve_id;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int[] getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(int[] reserve_id) {
		this.reserve_id = reserve_id;
	}

}