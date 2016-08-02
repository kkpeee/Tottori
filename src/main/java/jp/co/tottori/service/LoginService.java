package jp.co.tottori.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.tottori.dto.MypageRentalDto;
import jp.co.tottori.dto.MypageReserveDto;
import jp.co.tottori.dto.MypageUserDto;
import jp.co.tottori.entity.MypageRental;
import jp.co.tottori.entity.MypageReserve;
import jp.co.tottori.entity.MypageUser;
import jp.co.tottori.mapper.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Transactional
	public List<MypageReserveDto> getMypageReserve(String id) {
		List<MypageReserve> reserveList = loginMapper.getMypageReserve(id);
		List<MypageReserveDto> resultList = convertReserveToDto(reserveList);
		return resultList;
	}

	private List<MypageReserveDto> convertReserveToDto(List<MypageReserve> reserveList) {
		List<MypageReserveDto> resultList = new LinkedList<MypageReserveDto>();
		for (MypageReserve entity : reserveList) {
			MypageReserveDto dto = new MypageReserveDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}

	@Transactional
	public List<MypageRentalDto> getMypageRental(String id) {
		List<MypageRental> rentalList = loginMapper.getMypageRental(id);
		List<MypageRentalDto> resultList = convertRentalToDto(rentalList);
		return resultList;
	}

	private List<MypageRentalDto> convertRentalToDto(List<MypageRental> rentalList) {
		List<MypageRentalDto> resultList = new LinkedList<MypageRentalDto>();
		for (MypageRental entity : rentalList) {
			MypageRentalDto dto = new MypageRentalDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}

	@Transactional
	public MypageUserDto getMypageUser(String id) {
		MypageUserDto dto = new MypageUserDto();
		MypageUser entity = loginMapper.getMypageUser(id);
		if(entity != null) {
			BeanUtils.copyProperties(entity, dto);
		} else {
			return null;
		}
			return dto;
	}
}
