package com.pro.kkst.daos;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.kkst.imp.I_AccountDao;

@Repository
public class AccountDao implements I_AccountDao {
	@Autowired
	SqlSessionTemplate sqlSessoin;
	String namespace="com.pro.account.";

}
