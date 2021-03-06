package com.pro.kkst.daos;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.kkst.dtos.AttrsDto;
import com.pro.kkst.dtos.MenuzDto;
import com.pro.kkst.dtos.ResDto;
import com.pro.kkst.dtos.TasteDto;
import com.pro.kkst.dtos.WatchaDto;
import com.pro.kkst.dtos.menuDto;
import com.pro.kkst.imp.I_UserDao;
@Repository
public class UserDao implements I_UserDao {
	@Autowired
	SqlSessionTemplate sqlSessoin;
	String namespace="com.pro.user.";
	
	@Override
	public List<menuDto> menuList() {
		return sqlSessoin.selectList(namespace+"menulist");
	}

	@Override
	public List<menuDto> food(Map<String, int[]> map) {
		return sqlSessoin.selectList(namespace+"foodchosse",map);
	}
	
	@Override
	public List<ResDto> ResList(String cate) {
		return sqlSessoin.selectList(namespace+"ResList",cate) ;
	}

	@Override
	public String[] getCateCode() {
		return (String[])sqlSessoin.selectList(namespace+"getCateCode").toArray(new String[0]);
	}

	@Override
	public int getMenuCount(Map<String, String> map) {
		return sqlSessoin.selectOne(namespace+"getMenuCount", map);
	}

	@Override
	public WatchaDto getWatchaBox(Map<String, String> map) {
		return sqlSessoin.selectOne(namespace+"watchaBox", map);
	}

	@Override
	public int updateSetStars(Map<String, String> map) {
		return sqlSessoin.update(namespace+"setStars", map);
	}

	@Override
	public int selectHasZero(Map<String, String> map) {
		return sqlSessoin.selectOne(namespace+"hasZero", map);
	}

	@Override
	public List<AttrsDto> selectGetZeros2(Map<String, String[]> map) {
		return sqlSessoin.selectList(namespace+"getZeros2", map);
	}

	@Override
	public int selectGetZeroMenuCount2(Map<String, String[]> map) {
		return sqlSessoin.selectOne(namespace+"getZeroMenuCount2", map);
	}

	@Override
	public WatchaDto selectGetZeroMenu(Map<String, String[]> map) {
		return sqlSessoin.selectOne(namespace+"getZeroMenu", map);
	}

	@Override
	public int selectSearchSeq(Map<String, String> map) {
		return sqlSessoin.selectOne(namespace+"searchSeq", map);
	}

	@Override
	public int selectGetAttrCount() {
		return sqlSessoin.selectOne(namespace+"getAttrCount");
	}

	@Override
	public int insertRegist_taste(Map<String, String> map) {
		return sqlSessoin.insert(namespace+"regist_taste", map);
	}

	@Override
	public List<TasteDto> selectGetMyTaste(Map<String, String> map) {
		return sqlSessoin.selectList(namespace+"getMyTaste", map);
	}

	@Override
	public List<MenuzDto> selectRecommendMenuList(Map<String, String> map) {
		return sqlSessoin.selectList(namespace+"recommendMenuList", map);
	}

	@Override
	public int selectHasTaste(Map<String, String> map) {
		return sqlSessoin.selectOne(namespace+"hasTaste", map);
	}

	@Override
	public int selectGetAllMenuCount(Map<String, String> map) {
		return sqlSessoin.selectOne(namespace+"getAllMenuCount", map);
	}

	@Override
	public WatchaDto selectWatchaMoreMoreBox(Map<String, String> map) {
		return sqlSessoin.selectOne(namespace+"watchaMoreMoreBox", map);
	}

}
