package jp.co.tottori.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.tottori.dto.ManageDto;
import jp.co.tottori.entity.Manage;
import jp.co.tottori.mapper.ManageMapper;

@Service
public class ManageService {

	@Autowired
    private ManageMapper ManageMapper;

	@Transactional
	 public ManageDto getManager(ManageDto dto) {
	        Manage entity = ManageMapper.getManager(dto);
	        BeanUtils.copyProperties(entity, dto);
	        return dto;
	    }
}