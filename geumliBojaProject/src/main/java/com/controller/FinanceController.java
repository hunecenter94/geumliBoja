package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.service.FinanceService;
import com.service.FinanceVo;
import com.service.model.Finance;
import com.util.PageNavigation;

/**
 * @Class Name  : FinanceController.java
 * @Description :  
 * @Modification Information
 *
 *    수정일              수정자         수정내용
 *    -------  -------  -------------------
 *    2020. 5. 4.	JHY    	최초생성
 *
 * @author JHY
 * @since 2020. 5. 4.
 * @version 1.0
 * @see
 */

@Controller
public class FinanceController {
	
	@Resource(name="FinanceService")
	private FinanceService financeService;
	
	@RequestMapping("/artclList")
	public String artclList(
			@ModelAttribute( "vo" ) FinanceVo vo,
			ModelMap model) {
		System.out.println("test");
		/*
		 * if(vo.getPage()==null) { vo.setPage(1); }
		 * 
		 * if(vo.getCode()==null || "".equals(vo.getCode())){ vo.setCode("020000"); }
		 * 
		 * getJsonData(vo, model);
		 */		
		
		if(vo.getPage()==null) {
			vo.setPage(1);
		}
		
		if(vo.getCode()==null || "".equals(vo.getCode())){
			vo.setCode("020000");
		}
		
		if(vo.getSavingType()==null || "".equals(vo.getSavingType())) {
			vo.setSavingType(FinanceService.DEPOSIT);
		}
		
		List<Finance> financeList = financeService.getData(vo.getCode(), vo.getPage(), vo.getSavingType());
		model.addAttribute("financeList", financeList);
		
		PageNavigation pageNavi = new PageNavigation( vo.getPage(), vo.getRow() );
		pageNavi.setCount( financeList.size() );
		model.addAttribute( "pageNavi", pageNavi );
		
		System.out.println(pageNavi);
		return "artclList";
	}
	
	@ResponseBody
	@RequestMapping("/getJsonData")
	public String getJsonData(	
			@ModelAttribute( "vo" ) FinanceVo vo,
			ModelMap model) {
		if(vo.getPage()==null) {
			vo.setPage(1);
		}
		
		if(vo.getCode()==null || "".equals(vo.getCode())){
			vo.setCode("020000");
		}
		
		//List<Finance> financeList = financeService.getData(vo.getCode(), vo.getPage());
		//model.addAttribute("financeList", financeList);
		
		//JsonObject json = financeService.getJsonData(vo.getCode(), vo.getPage());
		//return json.toString();
		return null;
	}
}


