package com.pro.kkst.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.kkst.dtos.AttrsDto;
import com.pro.kkst.dtos.MenuzDto;
import com.pro.kkst.dtos.ResDto;
import com.pro.kkst.dtos.TasteDto;
import com.pro.kkst.dtos.WatchaDto;
import com.pro.kkst.dtos.menuDto;
import com.pro.kkst.imp.I_UserDao;
import com.pro.kkst.imp.I_UserService;
import com.pro.kkst.utils.Us_Utils;

//@Transactional
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

	@Transactional
	@Override
	public List<WatchaDto> watchaBox() {
		Us_Utils utils = new Us_Utils();
		WatchaDto dto = new WatchaDto();
		List<WatchaDto> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		int count=0;
		String[] ary=userDao.getCateCode();
		for (int i = 0; i < ary.length; i++) {
			map.put("codez", ary[i]);
			count=userDao.getMenuCount(map);
			count=utils.randomBox(count)+1;
			map.put("count", count+"");
			dto=userDao.getWatchaBox(map);
			list.add(dto);
		}
		return list;
	}

	@Override
	public boolean setStars(int stars, int user_seq, String codes) {
		int count=0;
		Map<String, String> map = new HashMap<>();
		map.put("stars", stars+"");
		map.put("user_seq", user_seq+"");
		map.put("code1", codes.substring(0, 1));
		map.put("code2", codes.substring(1, 2));
		map.put("code3", codes.substring(2, 3));
		map.put("code4", codes.substring(3, 4));
		map.put("code5", codes.substring(4, 5));
		count=userDao.updateSetStars(map);
		return count>0?true:false;
	}

	@Override
	public boolean hasZero(int user_seq) {
		int count=0;
			Map<String, String> map = new HashMap<>();
			map.put("user_seq", ""+user_seq);
			count=userDao.selectHasZero(map);
		return count>0?true:false;
	}

	@Transactional
	@Override
	public List<WatchaDto> watchaMoreBox(int user_seq) {
		Us_Utils utils = new Us_Utils();
		WatchaDto dto= new WatchaDto();
		List<WatchaDto> list = new ArrayList<>();
		List<AttrsDto> lists = new ArrayList<>();
		int count=0;
		Map<String, String[]> map = new HashMap<>();
		String[] a1= {""};
		String[] a2= {""};
		String[] a3= {""};
		String[] a4= {""};
		a1[0]=user_seq+"";
		map.put("user_seq", a1);
		
		//속성평점이 0 인 속성과, 그 속성에 해당하는 Type을 Dto에 담아 List로 받는다.
		lists=userDao.selectGetZeros2(map);
		
		//seqs에 0넣는 사전준비
		String[] seqs=new String[lists.size()+1];
		for (int i = 0; i < seqs.length; i++) {
			seqs[i]="0";
		}
		
		//속성평점0인 속성들의 갯수대로 해당속성의 메뉴를 랜덤으로 뽑는다.
		for (int j = 0; j < lists.size(); j++) {
			a2[0]=lists.get(j).getType().substring(0, 1);
			a3[0]=lists.get(j).getCode();
			map.put("types", a2);
			map.put("codez", a3);
			count=userDao.selectGetZeroMenuCount2(map);
			count=utils.randomBox(count)+1;
			a4[0]=count+"";
			map.put("count", a4);
			map.put("seqs", seqs);
			dto=userDao.selectGetZeroMenu(map);
			
			if (dto!=null) {
				seqs[j+1]=dto.getSeq()+""; //{0,1,2,3,4}
				list.add(dto);
			}
		}
		return list;
	}

	@Transactional
	@Override
	public boolean regist_taste(String id) {
		int count=0;
		int attrCount=0;
		int seq=0;
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		seq=userDao.selectSearchSeq(map);
		map.put("user_seq", seq+"");
		attrCount=userDao.selectGetAttrCount();
		for (int i = 0; i < attrCount; i++) {
			map.put("index", i+1+"");
			count=userDao.insertRegist_taste(map);
		}
		return count>0?true:false;
	}

	@Override
	public List<TasteDto> getMyTaste(int user_seq) {
		List<TasteDto> list=new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("user_seq", ""+user_seq);
		list=userDao.selectGetMyTaste(map);
		return list;
	}

	@Override
	public List<MenuzDto> recommendMenuList(int user_seq) {
		List<MenuzDto> list=new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		map.put("user_seq", ""+user_seq);
		list=userDao.selectRecommendMenuList(map);
		return list;
	}

	@Override
	public boolean hasTaste(int user_seq) {
		int count=0;
		Map<String, String> map = new HashMap<>();
		map.put("user_seq", ""+user_seq);
		count=userDao.selectHasTaste(map);
		return count>0?false:true;
	}

	@Transactional
	@Override
	public List<WatchaDto> watchaMoreMoreBox() {
		Us_Utils utils = new Us_Utils();
		WatchaDto dto = new WatchaDto();
		List<WatchaDto> list = new ArrayList<>();
		int count=0;
		int listCount=0;
		Map<String, String> map = new HashMap<>();
		listCount=userDao.selectGetAllMenuCount(map);
		int[] counts= {-1,-1,-1,-1,-1,-1,-1,-1,-1};
		boolean chk = true;
		for (int j = 0; j < 10; j++) {
			chk=true;
			while (chk) {
				count=utils.randomBox(listCount)+1;
				if (j>0) {
					for (int i = 0; i < counts.length; i++) {
						if (counts[i]==count) {
							chk=true;
							break;
						}else {
							chk=false;
						}
					}
				}else {
					break;
				}
			}
			map.put("count", count+"");
			dto=userDao.selectWatchaMoreMoreBox(map);
			if (j!=9) {
				counts[j]=count;
			}
			list.add(dto);
		}
		return list;
	}
	
	

}
