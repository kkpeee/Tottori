package jp.co.tottori.mapper;

import java.util.List;

import jp.co.tottori.dto.CheckDto;
import jp.co.tottori.dto.DocumentDto;
import jp.co.tottori.dto.ReserveDto;
import jp.co.tottori.dto.SearchDto;
import jp.co.tottori.entity.Reserve;
import jp.co.tottori.entity.Search;

public interface ReserveMapper {

	List<Search> getSearchedBook(SearchDto dto);

	List<DocumentDto> documentName();

	List<Search> getCheckBook(CheckDto dto);

	List<String> checkUser(ReserveDto dto);

	void reserveInsert(ReserveDto dto);

	List<Reserve> reservedBook(ReserveDto dto);

	void reserveCancel(int reserve_id);
}