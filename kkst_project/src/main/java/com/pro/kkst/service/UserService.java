package com.pro.kkst.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.kkst.dtos.ResDto;
import com.pro.kkst.dtos.WatchaDto;
import com.pro.kkst.dtos.menuDto;
import com.pro.kkst.imp.I_UserDao;
import com.pro.kkst.imp.I_UserService;


@Service
public class UserService implements I_UserService {
	@Autowired
	private I_UserDao userDao;
	
	@Override
	public List<menuDto> menuList() {
		return userDao.menuList();
	}

	@Override
	public List<menuDto> food(Map<String, int[]> map) {
		return userDao.food(map);
	}
	
	@Override
	public List<ResDto> ResList(String cate) {
		return userDao.ResList(cate);
	}

	@Override
	public List<WatchaDto> watchaBox() {
		//해야되는데 유틸도있음.
		return null;
	}

}
