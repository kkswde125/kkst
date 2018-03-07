package com.pro.kkst.daos;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.kkst.dtos.ResDto;
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

}
