package com.service.model;
/**
 * @Class Name  : Finance.java
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
public class FinanceOption {
    
    //상품 옵션정보
	private String	fin_prdt_cd; // **	금융상품 코드
    private String  intr_rate_type;//	저축 금리 유형
    private String  intr_rate_type_nm;//	저축 금리 유형명 [복리 : 단리]
    private String  save_trm;//	저축 기간 [단위: 개월]
    private String	intr_rate;//	저축 금리 [소수점 2자리]
    private String  intr_rate2;//	최고 우대금리 [소수점 2자리]
    
	public String getFin_prdt_cd() {
		return fin_prdt_cd;
	}
	public void setFin_prdt_cd(String fin_prdt_cd) {
		this.fin_prdt_cd = fin_prdt_cd;
	}
	public String getIntr_rate_type() {
		return intr_rate_type;
	}
	public void setIntr_rate_type(String intr_rate_type) {
		this.intr_rate_type = intr_rate_type;
	}
	public String getIntr_rate_type_nm() {
		return intr_rate_type_nm;
	}
	public void setIntr_rate_type_nm(String intr_rate_type_nm) {
		this.intr_rate_type_nm = intr_rate_type_nm;
	}
	public String getSave_trm() {
		return save_trm;
	}
	public void setSave_trm(String save_trm) {
		this.save_trm = save_trm;
	}
	public String getIntr_rate() {
		return intr_rate;
	}
	public void setIntr_rate(String intr_rate) {
		this.intr_rate = intr_rate;
	}
	public String getIntr_rate2() {
		return intr_rate2;
	}
	public void setIntr_rate2(String intr_rate2) {
		this.intr_rate2 = intr_rate2;
	}
	@Override
	public String toString() {
		return "FinanceOption [fin_prdt_cd=" + fin_prdt_cd + ", intr_rate_type=" + intr_rate_type
				+ ", intr_rate_type_nm=" + intr_rate_type_nm + ", save_trm=" + save_trm + ", intr_rate=" + intr_rate
				+ ", intr_rate2=" + intr_rate2 + "]";
	}
	
	
}

