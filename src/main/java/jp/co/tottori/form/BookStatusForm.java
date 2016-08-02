package jp.co.tottori.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BookStatusForm {

	@NotNull(message = "エラー：ISBNを入力してください")
	@Min(value =1, message = "エラー：ISBNは1以上で入力してください")
	private Integer isbn;
	private int shelfId;
	private int libraryId;
	private int statusId;

	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getShelfId() {
		return shelfId;
	}
	public void setShelfId(int shelfId) {
		this.shelfId = shelfId;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}