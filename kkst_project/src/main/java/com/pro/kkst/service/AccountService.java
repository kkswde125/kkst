package com.pro.kkst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.kkst.imp.I_AccountDao;
import com.pro.kkst.imp.I_AccountService;

@Service
public class AccountService implements I_AccountService {
	@Autowired
	private I_AccountDao accountDao;

}
