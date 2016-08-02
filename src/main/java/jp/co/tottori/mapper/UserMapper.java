package jp.co.tottori.mapper;

import java.util.List;

import jp.co.tottori.dto.BlackListDto;
import jp.co.tottori.dto.RentalDto;
import jp.co.tottori.dto.ReserveDto;
import jp.co.tottori.dto.UserDto;

public interface UserMapper {

	void insert(UserDto dto);

	UserDto search(UserDto dto);

	void update(UserDto dto);

	List<BlackListDto> blackList();

	List<UserDto> userIdCheck(UserDto dto);

	List<UserDto> mailCheck(UserDto dto);

	List<UserDto> phoneNumberCheck(UserDto dto);

	List<UserDto> updateConfirm(RentalDto dto);

	List<UserDto> updateConfirm(ReserveDto dto);

	List<UserDto> userManagement();

	void changeDate(UserDto dto);
}