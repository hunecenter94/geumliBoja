package com.service;
/**
 * @Class Name  : FinanceVo.java
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
public class FinanceVo {
	private String total_count; //총 상품 건수
    private Long max_page_no; //총 페이지 건수(총 페이지 건수 = 총 상품건수/1회 조회 개수*)
    private Integer page=1;
    private Integer row=10;
    private String code;
    private String savingType;
    
    public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
	public Long getMax_page_no() {
		return max_page_no;
	}
	public void setMax_page_no(Long max_page_no) {
		this.max_page_no = max_page_no;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSavingType() {
		return savingType;
	}
	public void setSavingType(String savingType) {
		this.savingType = savingType;
	}
}

