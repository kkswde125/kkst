package com.pro.kkst;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pro.kkst.dtos.ResDto;
import com.pro.kkst.dtos.menuDto;
import com.pro.kkst.imp.I_UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private I_UserService userServ;
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "reslist.do")
	public String reslist(Locale locale, Model model,String cate) {
		
		List<ResDto> lists =userServ.ResList(cate);
		
		model.addAttribute("lists",lists);
		
		
		return "resMap";
	}
	
	@RequestMapping(value="olympic.do")
	public String olympic(Locale locale, Model model) {
		
		List<menuDto> lists1=userServ.menuList();
		List<menuDto> lists2=null;
		
		int[]seqs=new int[16];
		
		
		int num=0;
		boolean chk=true;
		for (int i = 0; i <seqs.length; i++) {
				chk=true;
			while (chk) {
				
				num = (int)(Math.random()*lists1.size()+1);
				
				if (i>0) {
					
					for (int j = 0; j < seqs.length; j++) {
						if (seqs[j]==num) {
							chk=true;
							break;
						}else {
							chk=false;
						}
					}
					
				}else {
					break;
				}
				
				System.out.println(num);
				
			}
			
			seqs[i]= num;
			
		}
		
		Map<String,int[]>map =new HashMap<String,int[]>();
		map.put("Rseq", seqs);
		
		
		lists2=userServ.food(map);
		
		model.addAttribute("lists",lists2);
		
		return "olympic";
	}
	
/*	@RequestMapping(value="randomFood.do")
	public String randomFood(Locale locale, Model model,String seq) {
		
		int[] seqs = new int[2];
		List<menuDto> lists1= menuservice.menuList();
			
			seqs[0]=(int)(Math.random()*lists1.size()+1);
			seqs[1]=Integer.parseInt(seq);
		Map<String,int[]>map =new HashMap<String,int[]>();
		map.put("Rseq", seqs);
		
		List<menuDto> lists2=menuservice.food(map);
		
		
		model.addAttribute("lists", lists2);
		
		
		
		return "food";
	}*/
	
	@RequestMapping(value="winner.do")
	public String winner(Locale locale, Model model,String seq) {
		int[] seqs = new int[1]; 
		seqs[0]=Integer.parseInt(seq);
		
		Map<String,int[]>map =new HashMap<String,int[]>();
		map.put("Rseq", seqs);
		
		List<menuDto> lists = userServ.food(map);
		
		model.addAttribute("lists1", lists);
			
		
		return "winner";
	}
	
	
	@RequestMapping(value="test.do")
	public String test(Locale locale, Model model,String[] seq) {
		
		System.out.println(seq);
		
		return "";
	}
	
	
	
}
