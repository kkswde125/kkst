package com.pro.kkst.daos;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.kkst.dtos.ResDto;
import com.pro.kkst.imp.KkstResDao;

@Repository
public class ResDao implements KkstResDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	String namespace="com.pro.kkst.";
	
	@Override
	public List<ResDto> ResList(String cate) {
		return sqlSession.selectList(namespace+"ResList",cate) ;
	}

}
