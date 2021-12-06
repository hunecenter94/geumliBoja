package com.util;

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
public class PageNavigation {

	/** 페이지번호 */
	private Integer page;
	/** 페이지번호2 */
	private Integer page2;
	/** 줄갯수 */
	private Integer resultsPerPage;
	/** 총갯수 */
	private Long count;
	/** 페이지 갯수 */
	private Integer pages;
	/** 총 페이징 단위 갯수 */
	private Integer blocks;
	/** 페이징 단위 */
	private Integer block;
	/** 첫 페이지 */
	private Integer firstPage;
	/** 마지막 페이지 번호 */
	private Integer lastPage;
	/** 페이징 단위당 출력될 페이지수 : 10 */
	private Integer pagesPerBlock = 10;	
	
	/** Constructor */
	public PageNavigation() {
		super();
	}

	
	/**
	 * Constructor
	 * @param page 페이지
	 * @param resultsPerPage 줄갯수
	 */
	public PageNavigation(Integer page, Integer resultsPerPage) {
		super();
		this.page = page;
		this.resultsPerPage = resultsPerPage;
	}

	/**
	 * 페이지 번호2를 가져온다.
	 * @return 페이지 번호2
	 */
	public Integer getPage2() {
		return page2;
	}

	/**
	 * 페이지 번호2를 설정한다.
	 * @param page2 페이지 번호2
	 */
	public void setPage2(Integer page2) {
		this.page2 = page2;
	}

	/**
	 * 총 페이징 단위갯수를 가져온다.
	 * @return 총 페이징 단위갯수
	 */
	public Integer getBlocks() {
		return blocks;
	}

	/**
	 * 총 페이징 단위갯수를 설정한다.
	 * @param blocks 총 페이징 단위갯수
	 */
	public void setBlocks(Integer blocks) {
		this.blocks = blocks;
	}

	/**
	 * 페이징 단위를 가져온다. 
	 * @return 페이징 단위
	 */
	public Integer getBlock() {
		return block;
	}

	/**
	 * 페이징 단위를 설정한다.
	 * @param block 페이징 단위
	 */
	public void setBlock(Integer block) {
		this.block = block;
	}

	/**
	 * 첫 페이지 번호를 가져온다.
	 * @return 첫 페이지 번호
	 */
	public Integer getFirstPage() {
		return firstPage;
	}

	/**
	 * 첫 페이지 번호를 설정한다.
 	 * @param firstPage 첫 페이지 번호
	 */
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}

	/**
	 * 마지막 페이지 번호를 가져온다.
	 * @return 마지막 페이지 번호
	 */
	public Integer getLastPage() {
		return lastPage;
	}

	/**
	 * 마지막 페이지 번호를 설정한다.
	 * @param lastPage 마지막 페이지 번호
	 */
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	/**
	 * 총 페이지 갯수를 가져온다.
	 * @return 총 페이지 갯수
	 */
	public Integer getPages() {
		return pages;
	}

	/**
	 * 총 페이지 갯수를 설정한다.
	 * @param pages 총 페이지 갯수
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	/**
	 * 페이지 번호를 가져온다.
	 * @return 페이지 번호
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 페이지 번호를 설정한다.
	 * @param page 페이지 번호
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 줄갯수를 가져온다.
	 * @return 줄갯수
	 */
	public Integer getResultsPerPage() {
		return resultsPerPage;
	}

	/**
	 * 줄갯수를 설정한다.
	 * @param resultsPerPage 줄갯수
	 */
	public void setResultsPerPage(Integer resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	/**
	 * 총 갯수를 가져온다.
	 * @return 총 갯수
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * <pre>
	 * 다음을 계산하여 설정한다.
	 * - 페이지번호
	 * - 총 페이지수
	 * - 페이징 블럭 수
	 * - 페이징 블럭
	 * - 첫페이지 번호
	 * - 마지막페이지 번호
	 * - 총 페이지갯수
	 * </pre> 
	 * @param count 총 갯수(java.lang.Long)
	 */
	public void setCount(Long count) {
		this.count = count;
		if(page==null){
			page = 1;
		}
		pages = (count == 0) ? 1 : (int) ((count - 1) / resultsPerPage) + 1;
		blocks = (int) Math.ceil(1.0 * pages / pagesPerBlock);
		block = (int) Math.ceil(1.0 * page / pagesPerBlock);
		firstPage = (block - 1) * pagesPerBlock + 1;
		lastPage = block * pagesPerBlock;
		if (lastPage > pages)
			lastPage = pages;
	}
	/**
	 * <pre>
	 * 다음을 계산하여 설정한다.
	 * - 페이지번호
	 * - 총 페이지수
	 * - 페이징 블럭 수
	 * - 페이징 블럭
	 * - 첫페이지 번호
	 * - 마지막페이지 번호
	 * - 총 페이지갯수
	 * </pre> 
	 * @param count 총 갯수(java.lang.Integer)
	 */
	public void setCount(Integer count) {
		this.count = count+0L;
		if(page==null){
			page = 1;
		}
		pages = (count == 0) ? 1 : (int) ((count - 1) / resultsPerPage) + 1;
		blocks = (int) Math.ceil(1.0 * pages / pagesPerBlock);
		block = (int) Math.ceil(1.0 * page / pagesPerBlock);
		firstPage = (block - 1) * pagesPerBlock + 1;
		lastPage = block * pagesPerBlock;
		if (lastPage > pages)
			lastPage = pages;
	}
	
	/**
	 * <pre>
	 * 다음을 계산하여 설정한다.
	 * - 페이지번호2
	 * - 총 페이지수
	 * - 페이징 블럭 수
	 * - 페이징 블럭
	 * - 첫페이지 번호
	 * - 마지막페이지 번호
	 * - 총 페이지갯수
	 * </pre> 
	 * @param count 총 갯수(java.lang.Long)
	 */
	public void setCount2(Long count) {
		this.count = count;
		if(page2==null){
			page2 = 1;
		}
		pages = (count == 0) ? 1 : (int) ((count - 1) / resultsPerPage) + 1;
		blocks = (int) Math.ceil(1.0 * pages / pagesPerBlock);
		block = (int) Math.ceil(1.0 * page2 / pagesPerBlock);
		firstPage = (block - 1) * pagesPerBlock + 1;
		lastPage = block * pagesPerBlock;
		if (lastPage > pages)
			lastPage = pages;
	}

	/**
	 * 페이징 단위를 가져온다.
	 * @return 페이징 단위
	 */
	public Integer getPagesPerBlock() {
		return pagesPerBlock;
	}

	/**
	 * 페이징 단위를 설정한다.
	 * @param pagesPerBlock 페이징 단위
	 */
	public void setPagesPerBlock(Integer pagesPerBlock) {
		this.pagesPerBlock = pagesPerBlock;
	}	
	
}