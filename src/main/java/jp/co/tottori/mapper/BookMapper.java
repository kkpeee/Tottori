package jp.co.tottori.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.tottori.dto.BookDto;
import jp.co.tottori.dto.LibraryDto;
import jp.co.tottori.dto.MypageRentalDto;
import jp.co.tottori.dto.RentalDto;
import jp.co.tottori.dto.ReserveDto;
import jp.co.tottori.dto.StatusDto;

@Component
public interface BookMapper {

	void insert(BookDto dto);

	void rental(RentalDto dto);

	List<LibraryDto> library();

	void returnBook(BookDto dto);

	List<BookDto> bookCheck(BookDto dto);

	List<MypageRentalDto> rentalConfirm(RentalDto dto);

	List<MypageRentalDto> rentalConfirm(ReserveDto dto);

	List<MypageRentalDto> delinquentBook(RentalDto dto);

	BookDto lendConfirm(RentalDto dto);

	void updateStatus(BookDto dto);

	void changeStatus(BookDto dto);

	List<StatusDto> status();

	List<BookDto> bookManagement();

	List<MypageRentalDto> rentalManagement();

	void changeDate(RentalDto dto);
}