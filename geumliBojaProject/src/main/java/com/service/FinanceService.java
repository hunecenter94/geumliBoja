package com.service;

import java.util.List;
import java.util.Map;

import com.google.gson.JsonObject;
import com.service.model.Finance;
import com.service.model.FinanceCompany;

/**
 * @Class Name  : FinanceService.java
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
public interface FinanceService {
	
	//1금융권
	public static final String BANK_1_CODE = "020000";
	//2금융권
	public static final String BANK_2_CODE = "030300";
	
	//정기예금
	public static final String DEPOSIT   = "deposit";
	//적금
	public static final String SAVING = "saving";
	
	/**
	 * 금융회사 정보
	 * @param code
	 * @param page
	 * @return
	 */
	public Map<String, FinanceCompany> getFinanceCompany(String code,Integer page);
	
	/**
	 * 상품 데이터
	 * @param code
	 * @param page
	 * @param savingType
	 * @return
	 */
	public List<Finance> getData(String code,Integer page, String savingType) ;
	
	/**
	 * 상품 데이터
	 * @param code
	 * @param page
	 * @return
	 */
	public JsonObject getJsonData(String code,Integer page) ;
}

