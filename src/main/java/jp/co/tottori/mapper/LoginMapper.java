package jp.co.tottori.mapper;

import java.util.List;

import jp.co.tottori.entity.MypageRental;
import jp.co.tottori.entity.MypageReserve;
import jp.co.tottori.entity.MypageUser;

public interface LoginMapper {

	public List<MypageReserve> getMypageReserve(String id);

	public List<MypageRental> getMypageRental(String id);

	public MypageUser getMypageUser(String id);

}
