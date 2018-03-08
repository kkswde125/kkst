package com.pro.kkst.imp;

import java.util.List;
import java.util.Map;

import com.pro.kkst.dtos.LoginDto;

public interface I_AccountService {

	public List<LoginDto> userList();
	public LoginDto id_return(Map<String, String> map);
	public LoginDto pw_return(Map<String, String> map);
	
}
