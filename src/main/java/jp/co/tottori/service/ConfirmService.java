package jp.co.tottori.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.tottori.dto.SearchDto;
import jp.co.tottori.entity.Search;
import jp.co.tottori.mapper.ConfirmMapper;

@Service
public class ConfirmService {

	@Autowired
	private ConfirmMapper confirmMapper;

	@Transactional
	public SearchDto getLendList(int isbn) {
		SearchDto lend = confirmMapper.getLendList(isbn);
		return lend;
	}

	@Transactional
	public SearchDto getReturnList(int isbn) {
		SearchDto return1 = confirmMapper.getReturnList(isbn);
		return return1;
	}

	@Transactional
	private List<SearchDto> convertConfirmToDto(List<Search> list) {
		List<SearchDto> resultList = new LinkedList<SearchDto>();
		for (Search entity : list) {
			SearchDto dto = new SearchDto();
			BeanUtils.copyProperties(entity, dto);
			resultList.add(dto);
		}
		return resultList;
	}
}
