package com.pro.kkst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.kkst.daos.ResDao;
import com.pro.kkst.dtos.ResDto;
import com.pro.kkst.imp.KkstResService;


@Service
public class ResService implements KkstResService {

	@Autowired
	private ResDao rdao;
	
	@Override
	public List<ResDto> ResList(String cate) {
		return rdao.ResList(cate);
	}

}
