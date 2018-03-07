package com.pro.kkst.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.kkst.daos.MenuDao;
import com.pro.kkst.dtos.menuDto;
import com.pro.kkst.imp.KkstMenuService;


@Service
public class MenuService implements KkstMenuService {
	@Autowired
	private MenuDao mdao;
	
	@Override
	public List<menuDto> menuList() {
		return mdao.menuList();
	}

	@Override
	public List<menuDto> food(Map<String, int[]> map) {
		return mdao.food(map);
	}

}
