package jp.co.tottori.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.tottori.dto.BlackListDto;
import jp.co.tottori.dto.RentalDto;
import jp.co.tottori.dto.ReserveDto;
import jp.co.tottori.dto.UserDto;
import jp.co.tottori.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
	//ユーザー登録
	@Transactional
    public void insert(UserDto dto) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR,1);
        Date afterTime = new java.sql.Date(cal.getTimeInMillis());
        dto.setUpdateTime(afterTime);
        try {
        		userMapper.insert(dto);
        } catch (Exception e) {
                   e.printStackTrace();
        }
    }

    //ユーザー検索
	@Transactional
    public UserDto search(UserDto dto) {
    	UserDto user = userMapper.search(dto);
    	return user;
    }

	@Transactional
    public void update(UserDto dto) {
       	Calendar cal = Calendar.getInstance();
    	Date date = new Date();
    	cal.setTime(date);
    	cal.add(Calendar.YEAR,1);
    	Date afterTime = new java.sql.Date(cal.getTimeInMillis());
    	dto.setUpdateTime(afterTime);
    	try {
            userMapper.update(dto);
    	} catch (Exception e) {
            e.printStackTrace();
    	}
    }

	@Transactional
    public List<BlackListDto> blackList() {
    	List<BlackListDto> blackList = userMapper.blackList();
    	return blackList;
    }

    //重複チェック
	@Transactional
    public List<String> userCheck(UserDto dto) {
    	List<String> messages = new ArrayList<String>();
    	List<UserDto> userIdCheck = userMapper.userIdCheck(dto);
    	List<UserDto> mailCheck = userMapper.mailCheck(dto);
    	List<UserDto> phoneNumberCheck = userMapper.phoneNumberCheck(dto);
    	if (userIdCheck.size() > 0) {
    		messages.add("そのユーザーIDは既に登録されています");
    	}
    	if (mailCheck.size() > 0) {
    		messages.add("そのメールアドレスは既に登録されています");
    	}
    	if (phoneNumberCheck.size() > 0) {
    		messages.add("その電話番号は既に登録されています");
    	}
    	return messages;
    }

    //重複チェック
	@Transactional
    public List<String> userUpdateCheck(UserDto dto) {
    	List<String> messages = new ArrayList<String>();
    	List<UserDto> userIdCheck = userMapper.userIdCheck(dto);
    	List<UserDto> mailCheck = userMapper.mailCheck(dto);
    	List<UserDto> phoneNumberCheck = userMapper.phoneNumberCheck(dto);
    	if (userIdCheck.size() > 1) {
    		messages.add("そのユーザーIDは既に登録されています");
    	}
    	if (mailCheck.size() > 1) {
    		messages.add("そのメールアドレスは既に登録されています");
    	}
    	if (phoneNumberCheck.size() > 1) {
    		messages.add("その電話番号は既に登録されています");
    	}
    	return messages;
    }
    //ユーザーが更新しているか
	@Transactional
    public boolean updateConfirm(RentalDto dto) {
    	List<UserDto> user = userMapper.updateConfirm(dto);
    	if (user.size() == 0){
    		return false;
    	}
    	return true;
    }

    //ユーザーが更新しているか
	@Transactional
    public boolean updateConfirm(ReserveDto dto) {
    	List<UserDto> user = userMapper.updateConfirm(dto);
    	if (user.size() == 0){
    		return false;
    	}
    	return true;
    }

    public List<UserDto> userManagement() {
    	List<UserDto> users = userMapper.userManagement();
    	return users;
    }

    public void changeDate(UserDto dto) {
    	userMapper.changeDate(dto);
    }

}