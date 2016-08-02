package jp.co.tottori.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("session")
public class BookSearchDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private static BookSearchDto bookDto;
	private int bookId;
	private String bookKana;
	private String bookKanaByte;
	private String bookName;
	private String authorKana;

	private String authorKanaByte;
	private String authorName;

	private String publisher;
	private Date rentalTime;

	private int isbn;

	private int shelfId;
	private int documentId;
	private int libraryId;
	private int statusId;

	public static BookSearchDto getBookDto() {
		if (bookDto == null) {
			bookDto = new BookSearchDto();
		}
		return bookDto;
	}

	public static void setBookDto(BookSearchDto Dto) {
		bookDto = Dto;
	}

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