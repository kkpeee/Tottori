package jp.co.tottori.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class BookRegisterForm {
	private int bookId;
	@NotEmpty(message = "エラー：書名のふりがなを入力してください")
	private String bookKana;
	private String bookKanaByte;
	@Size(max = 100, message = "エラー：書名が100文字を超えています")
	@NotEmpty(message = "エラー：書名を入力してください")
	private String bookName;
	@Size(max = 255, message = "エラー：著者名が255文字を超えています")
	private String authorKana;
	private String authorKanaByte;
	@Size(max = 255, message = "エラー：著者名のふりがなが255文字を超えています")
	@NotEmpty(message = "エラー：著者名を入力してください")
	private String authorName;
	@NotEmpty(message = "エラー：出版社名を入力してください")
	private String publisher;
	private Date rentalTime;
	@NotNull(message = "エラー：ISBNを入力してください")
	private Integer isbn;
	@Min(value=1, message = "エラー：棚番号は1以上で入力してください" )
	private Integer shelfId;
	@Min(value=1, message = "エラー：書類種類は1以上で入力してください" )
	private Integer documentId;
	private int libraryId;
	private int statusId;

	public String getBookKana() {
		return bookKana;
	}
	public void setBookKana(String bookKana) {
		this.bookKana = bookKana;
	}
	public String getAuthorKana() {
		return authorKana;
	}
	public void setAuthorKana(String authorKana) {
		this.authorKana = authorKana;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookKanaByte() {
		return bookKanaByte;
	}
	public void setBookKanaByte(String bookKanaByte) {
		this.bookKanaByte = bookKanaByte;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorKanaByte() {
		return authorKanaByte;
	}
	public void setAuthorKanaByte(String authorKanaByte) {
		this.authorKanaByte = authorKanaByte;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
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
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
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