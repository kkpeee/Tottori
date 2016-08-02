package jp.co.tottori.mapper;

import jp.co.tottori.dto.ManageDto;
import jp.co.tottori.entity.Manage;

public interface ManageMapper {

	Manage getManager(ManageDto dto);

}