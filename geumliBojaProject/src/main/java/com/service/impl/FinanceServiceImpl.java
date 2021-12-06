package com.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.FinanceService;
import com.service.FinanceVo;
import com.service.model.Finance;
import com.service.model.FinanceCompany;
import com.service.model.FinanceOption;
import com.util.PageNavigation;

/**
 * @Class Name  : FinanceServiceImpl.java
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
@Service("FinanceService")
public class FinanceServiceImpl implements FinanceService {
	
	/**
	 * 금융 회사 정보
	 */
	@Override
	public Map<String, FinanceCompany> getFinanceCompany(String code, Integer page) {
		return null;
	}
	
	/**
	 * 상품 데이터
	 */
	@Override
	public List<Finance> getData(String bankCode, Integer page, String savingType) {
		
		List<Finance> finanaceList = new ArrayList<>();
		List<FinanceOption> finanaceOptionList = new ArrayList<>();
		
		String reqURL = null;
		
		if(DEPOSIT.equals(savingType)) {//정기예금
			reqURL = "https://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json?auth=90296049e40c96f05ce89b8ef1114f18&topFinGrpNo="+bankCode+"&pageNo="+page;
		}else if(SAVING.equals(savingType)) {//적금
			reqURL = "https://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json?auth=90296049e40c96f05ce89b8ef1114f18&topFinGrpNo="+bankCode+"&pageNo="+page;
		}else {
			return null;
		}
		
        try {
        	//해당 사이트에 SSL 인증서가 신뢰하는 기관 인증서가 없거나 SSL/TLS암호화 버전이 맞지 않는 경우 SSLHandshakeException 
        	//그래서 유효하지 않은 SSL 인증서를 사용하는 서버에 접근하도록 설정을 해야 함
        	//sslTrustAllCerts();
        	
        	URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			 //요청에 필요한 Header에 포함될 내용
	        conn.setRequestProperty("Content-Type","application/json; charset=UTF-8;");
	        
	        int responseCode = conn.getResponseCode();
	        if(responseCode==200){
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		        
		        String line = "";
		        String result = "";
		        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        
		        JsonParser parser = new JsonParser();
		        JsonElement element = parser.parse(result);
		       
		        //상품 건수 및 페이지수
		        String total_count =null; //총 상품 건수
		        Long max_page_no = null; //총 페이지 건수(총 페이지 건수 = 총 상품건수/1회 조회 개수*)
		        
			    JsonObject jsonObject = null;
			    JsonArray baseList = null;
			    JsonArray optionList = null;
			    
		        jsonObject = element.getAsJsonObject().get("result").getAsJsonObject();
		        total_count = jsonObject.getAsJsonObject().get("total_count").getAsString();
		        max_page_no = (long) (Integer.parseInt(total_count)/10);
		        baseList = jsonObject.getAsJsonObject().get("baseList").getAsJsonArray();
		        optionList = jsonObject.getAsJsonObject().get("optionList").getAsJsonArray();
		        
		        
		        FinanceVo vo = new FinanceVo();
		        vo.setMax_page_no(max_page_no);
		        vo.setTotal_count(total_count);
		        
		        Finance finance = null;
		        FinanceOption financeOption = null;
		        //상품 코드
		        String Opfin_prdt_cd = null;
		        
		        Integer optionCnt = 0;
		        
		        PageNavigation pageNavi = new PageNavigation( vo.getPage(), vo.getRow() );
				pageNavi.setCount( baseList.size() );
		        
		        //상품 기본정보
		        for(int i=0; i<baseList.size(); i++) {
		        //for(int i=0; i<3; i++) {
		        	finance = new Finance();
		        	
		        	//**공시 제출월 [YYYYMM]
		        	finance.setDcls_month(baseList.get(i).getAsJsonObject().get("dcls_month").getAsString()!=null?baseList.get(i).getAsJsonObject().get("dcls_month").getAsString():"");
		        	//**금융회사 코드
		        	finance.setFin_co_no(baseList.get(i).getAsJsonObject().get("fin_co_no").getAsString()!=null?baseList.get(i).getAsJsonObject().get("fin_co_no").getAsString():"");
		        	//금융회사명
		        	finance.setKor_co_nm(baseList.get(i).getAsJsonObject().get("kor_co_nm").getAsString()!=null?baseList.get(i).getAsJsonObject().get("kor_co_nm").getAsString():"");
		        	//**금융상품 코드
		        	finance.setFin_prdt_cd(baseList.get(i).getAsJsonObject().get("fin_prdt_cd").getAsString()!=null?baseList.get(i).getAsJsonObject().get("fin_prdt_cd").getAsString():"");
		        	//금융 상품명
		        	finance.setFin_prdt_nm(baseList.get(i).getAsJsonObject().get("fin_prdt_nm").getAsString()!=null?baseList.get(i).getAsJsonObject().get("fin_prdt_nm").getAsString():"");
		        	//가입 방법
		        	finance.setJoin_way(baseList.get(i).getAsJsonObject().get("join_way").getAsString()!=null?baseList.get(i).getAsJsonObject().get("join_way").getAsString():"");
		        	//만기 후 이자율
		        	finance.setMtrt_int(baseList.get(i).getAsJsonObject().get("mtrt_int").getAsString()!=null?baseList.get(i).getAsJsonObject().get("mtrt_int").getAsString():"");
		        	//우대조건
		        	finance.setSpcl_cnd(baseList.get(i).getAsJsonObject().get("spcl_cnd").getAsString()!=null?baseList.get(i).getAsJsonObject().get("spcl_cnd").getAsString():"");
		        	//가입제한 Ex) 1:제한없음, 2:서민전용, 3:일부제한
		        	finance.setJoin_deny(baseList.get(i).getAsJsonObject().get("join_deny").getAsString()!=null?baseList.get(i).getAsJsonObject().get("join_deny").getAsString():"");
		        	//가입대상
		        	finance.setJoin_member(baseList.get(i).getAsJsonObject().get("join_member").getAsString()!=null?baseList.get(i).getAsJsonObject().get("join_member").getAsString():"");
		        	//기타 유의사항
		        	finance.setEtc_note(baseList.get(i).getAsJsonObject().get("etc_note").getAsString()!=null?baseList.get(i).getAsJsonObject().get("etc_note").getAsString():"");
		        	//최고한도
		        	//finance.setMax_limit(baseList.get(i).getAsJsonObject().get("max_limit")!=null?baseList.get(i).getAsJsonObject().get("max_limit").getAsString():"");
		        	//공시 시작일
		        	finance.setDcls_strt_day(baseList.get(i).getAsJsonObject().get("dcls_strt_day").getAsString()!=null?baseList.get(i).getAsJsonObject().get("dcls_strt_day").getAsString():"");
		        	//공시 종료일
		        	//finance.setDcls_end_day(baseList.get(i).getAsJsonObject().get("dcls_end_day")!=null?baseList.get(i).getAsJsonObject().get("dcls_end_day").getAsString():"");
		        	//금융회사 제출일 [YYYYMMDDHH24MI]
		        	finance.setFin_co_subm_day(baseList.get(i).getAsJsonObject().get("fin_co_subm_day").getAsString()!=null?baseList.get(i).getAsJsonObject().get("fin_co_subm_day").getAsString():"");
		        	
		        	for(int j=0; j<optionList.size(); j++) {
		        	//for(int j=0; j<10; j++) {
		        		
		        		Opfin_prdt_cd = optionList.get(j).getAsJsonObject().get("fin_prdt_cd").getAsString()!=null?optionList.get(j).getAsJsonObject().get("fin_prdt_cd").getAsString():"";
		        		if(finance.getFin_prdt_cd().equals(Opfin_prdt_cd)) {
		        			financeOption = new FinanceOption();
			        		//금융상품코드
			        		financeOption.setFin_prdt_cd(optionList.get(j).getAsJsonObject().get("fin_prdt_cd").getAsString()!=null?optionList.get(j).getAsJsonObject().get("fin_prdt_cd").getAsString():"");
			        		//저축 금리 유형
			        		financeOption.setIntr_rate_type(optionList.get(j).getAsJsonObject().get("intr_rate_type").getAsString()!=null?optionList.get(j).getAsJsonObject().get("intr_rate_type").getAsString():"");
			        		//저축 금리 유형명
			        		financeOption.setIntr_rate_type_nm(optionList.get(j).getAsJsonObject().get("intr_rate_type_nm").getAsString()!=null?optionList.get(j).getAsJsonObject().get("intr_rate_type_nm").getAsString():"");
			        		//저축 기간[단위 : 개월]
			        		financeOption.setSave_trm(optionList.get(j).getAsJsonObject().get("save_trm").getAsString()!=null?optionList.get(j).getAsJsonObject().get("save_trm").getAsString():"");
			        		//저축 금리 [소수점 2자리]
			        		financeOption.setIntr_rate(optionList.get(j).getAsJsonObject().get("intr_rate").getAsString()!=null?optionList.get(j).getAsJsonObject().get("intr_rate").getAsString():"");
			        		//최고 우대금리 [소수점 2자리]
			        		financeOption.setIntr_rate2(optionList.get(j).getAsJsonObject().get("intr_rate2").getAsString()!=null?optionList.get(j).getAsJsonObject().get("intr_rate2").getAsString():"");
			        		
			        		finanaceOptionList.add(financeOption);
			        		
			        		optionCnt++;
		        		}
		        	}
		        	finance.setOptionList(finanaceOptionList);
		        		
		        	//옵션 갯수
		        	finance.setOptionCnt(optionCnt);
	        		
	        		optionCnt = 0;
		        	
	        		//추가
		        	finanaceList.add(finance);
		        }
		        
		        //상품 옵션정보
		       /* for(Finance artcl : finanaceList) {
		        	for(int i=0; i<optionList.size(); i++) {
		        		//저축 금리 유형2
		        		artcl.setFin_co_subm_day(baseList.get(i).getAsJsonObject().get("intr_rate_type").getAsString()!=null?baseList.get(i).getAsJsonObject().get("intr_rate_type").getAsString():"");
		        		//저축 금리 유형명
		        		artcl.setFin_co_subm_day(baseList.get(i).getAsJsonObject().get("intr_rate_type_nm").getAsString()!=null?baseList.get(i).getAsJsonObject().get("intr_rate_type_nm").getAsString():"");
		        		//저축 기간 [단위: 개월]
		        		artcl.setFin_co_subm_day(baseList.get(i).getAsJsonObject().get("save_trm").getAsString()!=null?baseList.get(i).getAsJsonObject().get("save_trm").getAsString():"");
		        		//저축 금리 [소수점 2자리]
		        		artcl.setFin_co_subm_day(baseList.get(i).getAsJsonObject().get("intr_rate").getAsString()!=null?baseList.get(i).getAsJsonObject().get("intr_rate").getAsString():"");
		        		//최고 우대금리 [소수점 2자리]
		        		artcl.setFin_co_subm_day(baseList.get(i).getAsJsonObject().get("intr_rate2").getAsString()!=null?baseList.get(i).getAsJsonObject().get("intr_rate2").getAsString():"");
		        	}
		        }*/
		        
		        
		       
				br.close();
	        }else {
	        	finanaceList = null;
	        }
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return finanaceList;
	}
	
	/**
	 * sslTrustAllCerts
	 * 해당 사이트에 SSL 인증서가 신뢰하는 기관 인증서가 없거나 SSL/TLS암호화 버전이 맞지 않는 경우 SSLHandshakeException 
	 * 그래서 유효하지 않은 SSL 인증서를 사용하는 서버에 접근하도록 설정을 해야 함
	 */
	public void sslTrustAllCerts(){
		 TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		    	public X509Certificate[] getAcceptedIssuers() {
		    		return null;
		    	}
		
		    	public void checkClientTrusted(X509Certificate[] certs, String authType) {
		
		    	}
		
		    	public void checkServerTrusted(X509Certificate[] certs, String authType) {
		
		    	}
			}
		};
	 
		SSLContext sc;
		try {
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JsonObject getJsonData(String code, Integer page) {
		JsonObject jsonObject = null;
		//정기예금
		String reqURL = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json?auth=90296049e40c96f05ce89b8ef1114f18&topFinGrpNo="+code+"&pageNo="+page;
		
        try {
        	//해당 사이트에 SSL 인증서가 신뢰하는 기관 인증서가 없거나 SSL/TLS암호화 버전이 맞지 않는 경우 SSLHandshakeException 
        	//그래서 유효하지 않은 SSL 인증서를 사용하는 서버에 접근하도록 설정을 해야 함
        	//sslTrustAllCerts();
        	
        	URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			 //요청에 필요한 Header에 포함될 내용
	        conn.setRequestProperty("Content-Type","application/json; charset=UTF-8;");
	        
	        int responseCode = conn.getResponseCode();
	        if(responseCode==200){
		        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		        
		        String line = "";
		        String result = "";
		        
		        while ((line = br.readLine()) != null) {
		            result += line;
		        }
		        System.out.println("response body : " + result);
		        
		        JsonParser parser = new JsonParser();
		        JsonElement element = parser.parse(result);
		       
		        
		        jsonObject = element.getAsJsonObject().get("result").getAsJsonObject();
		       
				br.close();
	        }
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
}

