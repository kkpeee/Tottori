package jp.co.tottori.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.tottori.dto.BlackListDto;
import jp.co.tottori.entity.BlackList;
import jp.co.tottori.mapper.BlackListMapper;

@Service
public class BlackListService {

	@Autowired
	private BlackListMapper blackListMapper;

	@Transactional
	public List<BlackListDto> getBlackList() {
		List<BlackList> blackList = blackListMapper.getBlackList();
		List<BlackListDto> resultList = convertBlackListToDto(blackList);
		return resultList;
	}

	@Transactional
	private List<BlackListDto> convertBlackListToDto(List<BlackList> blackList) {
		List<BlackListDto> resultList = new LinkedList<BlackListDto>();
		for (BlackList entity : blackList) {
			BlackListDto dto = new BlackListDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
}
