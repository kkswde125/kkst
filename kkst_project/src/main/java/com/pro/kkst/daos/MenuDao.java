package com.pro.kkst.daos;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.kkst.dtos.menuDto;
import com.pro.kkst.imp.KkstMenuDao;
@Repository
public class MenuDao implements KkstMenuDao {
	@Autowired
	SqlSessionTemplate sqlSessoin;
	String namespace="com.pro.kkst.";
	
	@Override
	public List<menuDto> menuList() {
		return sqlSessoin.selectList(namespace+"menulist");
	}

	@Override
	public List<menuDto> food(Map<String, int[]> map) {
		return sqlSessoin.selectList(namespace+"foodchosse",map);
	}

}
