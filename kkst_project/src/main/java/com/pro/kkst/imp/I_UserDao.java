package com.pro.kkst.imp;

import java.util.List;
import java.util.Map;

import com.pro.kkst.dtos.ResDto;
import com.pro.kkst.dtos.menuDto;

public interface I_UserDao {
	public List<menuDto> menuList();
	public List<menuDto> food(Map<String, int[]> map);
	public List<ResDto> ResList(String cate);
}