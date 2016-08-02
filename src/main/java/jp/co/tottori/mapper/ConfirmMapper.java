package jp.co.tottori.mapper;

import jp.co.tottori.dto.SearchDto;
public interface ConfirmMapper {

	public SearchDto getLendList(int isbn);

	public SearchDto  getReturnList(int isbn);
}
