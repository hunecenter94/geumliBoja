<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE HTML>
<html>

<head>
    <title>Traveler - Booking History</title>
 
	<%@ include file="/WEB-INF/jsp/artclList.head.jsp" %> 
	
</head>

<body>

    <!-- FACEBOOK WIDGET -->
    <div id="fb-root"></div>
    <script>
        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s);
            js.id = id;
            js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
    </script>
    <!-- /FACEBOOK WIDGET -->
    <div class="global-wrap">
        <header id="main-header">
            <div class="header-top">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <a class="logo" href="index.html">
                                <img src="/Web-home/img/logo-invert.png" alt="Image Alternative text" title="Image Title" />
                            </a>
                        </div>
                        <div class="col-md-3 col-md-offset-2">
                            <form class="main-header-search">
                                <div class="form-group form-group-icon-left">
                                    <i class="fa fa-search input-icon"></i>

                                    <input type="text" class="form-control">
                                </div>
                            </form>
                        </div>
                        <div class="col-md-4">
                            <div class="top-user-area clearfix">
                                <ul class="top-user-area-list list list-horizontal list-border">
                                    <li class="top-user-area-avatar">
                                        <a href="user-profile.html">
                                            <img class="origin round" src="/Web-home/img/40x40.png" alt="Image Alternative text" title="AMaze" />Hi, John</a>
                                    </li>
                                    <li><a href="#">Sign Out</a>
                                    </li>
                                    <li class="nav-drop"><a href="#">USD $<i class="fa fa-angle-down"></i><i class="fa fa-angle-up"></i></a>
                                        <ul class="list nav-drop-menu">
                                            <li><a href="#">EUR<span class="right">€</span></a>
                                            </li>
                                            <li><a href="#">GBP<span class="right">£</span></a>
                                            </li>
                                            <li><a href="#">JPY<span class="right">円</span></a>
                                            </li>
                                            <li><a href="#">CAD<span class="right">$</span></a>
                                            </li>
                                            <li><a href="#">AUD<span class="right">A$</span></a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="top-user-area-lang nav-drop">
                                        <a href="#">
                                            <img src="/Web-home/img/flags/32/uk.png" alt="Image Alternative text" title="Image Title" />ENG<i class="fa fa-angle-down"></i><i class="fa fa-angle-up"></i>
                                        </a>
                                        <ul class="list nav-drop-menu">
                                            <li>
                                                <a title="German" href="#">
                                                    <img src="/Web-home/img/flags/32/de.png" alt="Image Alternative text" title="Image Title" /><span class="right">GER</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a title="Japanise" href="#">
                                                    <img src="/Web-home/img/flags/32/jp.png" alt="Image Alternative text" title="Image Title" /><span class="right">JAP</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a title="Italian" href="#">
                                                    <img src="/Web-home/img/flags/32/it.png" alt="Image Alternative text" title="Image Title" /><span class="right">ITA</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a title="French" href="#">
                                                    <img src="/Web-home/img/flags/32/fr.png" alt="Image Alternative text" title="Image Title" /><span class="right">FRE</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a title="Russian" href="#">
                                                    <img src="/Web-home/img/flags/32/ru.png" alt="Image Alternative text" title="Image Title" /><span class="right">RUS</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a title="Korean" href="#">
                                                    <img src="/Web-home/img/flags/32/kr.png" alt="Image Alternative text" title="Image Title" /><span class="right">KOR</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="nav">
                    <ul class="slimmenu" id="slimmenu">
                        <li><a href="index.html">Home</a>
                            <ul>
                                <li><a href="index.html">Default</a>
                                </li>
                                <li><a href="index-1.html">Layout 1</a>
                                </li>
                                <li><a href="index-2.html">Layout 2</a>
                                </li>
                                <li><a href="index-3.html">Layout 3</a>
                                </li>
                                <li><a href="index-4.html">Layout 4</a>
                                </li>
                                <li><a href="index-5.html">Layout 5</a>
                                </li>
                                <li><a href="index-6.html">Layout 6</a>
                                </li>
                                <li><a href="index-7.html">Layout 7</a>
                                </li>
                            </ul>
                        </li>
                        <li class="active"><a href="success-payment.html">Pages</a>
                            <ul>
                                <li><a href="success-payment.html">Success Payment</a>
                                </li>
                                <li class="active"><a href="user-profile.html">User Profile</a>
                                    <ul>
                                        <li><a href="user-profile.html">Overview</a>
                                        </li>
                                        <li><a href="user-profile-settings.html">Settings</a>
                                        </li>
                                        <li><a href="user-profile-photos.html">Photos</a>
                                        </li>
                                        <li class="active"><a href="user-profile-booking-history.html">Booking History</a>
                                        </li>
                                        <li><a href="user-profile-cards.html">Cards</a>
                                        </li>
                                        <li><a href="user-profile-wishlist.html">Wishlist</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="blog.html">Blog</a>
                                    <ul>
                                        <li><a href="blog.html">Sidebar Right</a>
                                        </li>
                                        <li><a href="blog-sidebar-left.html">Sidebar Left</a>
                                        </li>
                                        <li><a href="blog-full-width.html">Full Width</a>
                                        </li>
                                        <li><a href="blog-post.html">Post</a>
                                            <ul>
                                                <li><a href="blog-post.html">Sidebar Right</a>
                                                </li>
                                                <li><a href="blog-post-sidebar-left.html">Sidebar Left</a>
                                                </li>
                                                <li><a href="blog-post-full-width.html">Full Width</a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="404.html">404 page</a>
                                </li>
                                <li><a href="contact-us.html">Contact Us</a>
                                </li>
                                <li><a href="about.html">About</a>
                                </li>
                                <li><a href="login-register.html">Login/Register</a>
                                    <ul>
                                        <li><a href="login-register.html">Full Page</a>
                                        </li>
                                        <li><a href="login-register-normal.html">Normal</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="loading.html">Loading</a>
                                </li>
                                <li><a href="comming-soon.html">Comming Soon</a>
                                </li>
                                <li><a href="gallery.html">Gallery</a>
                                    <ul>
                                        <li><a href="gallery.html">4 Columns</a>
                                        </li>
                                        <li><a href="gallery-3-col.html">3 columns</a>
                                        </li>
                                        <li><a href="gallery-2-col.html">2 columns</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="page-full-width.html">Full Width</a>
                                </li>
                                <li><a href="page-sidebar-right.html">Sidebar Right</a>
                                </li>
                                <li><a href="page-sidebar-left.html">Sidebar Left</a>
                                </li>
                            </ul>
                        </li>
                        <li><a href="feature-typography.html">Features</a>
                            <ul>
                                <li><a href="feature-typography.html">Typography</a>
                                </li>
                                <li><a href="feature-icons.html">Icons</a>
                                </li>
                                <li><a href="feature-forms.html">Forms</a>
                                </li>
                                <li><a href="feature-icon-effects.html">Icon Effects</a>
                                </li>
                                <li><a href="feature-elements.html">Elements</a>
                                </li>
                                <li><a href="feature-grid.html">Grid</a>
                                </li>
                                <li><a href="feature-hovers.html">Hover effects</a>
                                </li>
                                <li><a href="feature-lightbox.html">Lightbox</a>
                                </li>
                                <li><a href="feature-media.html">Media</a>
                                </li>
                            </ul>
                        </li>
                        <li><a href="hotels.html">Hotels</a>
                            <ul>
                                <li><a href="hotel-details.html">Details</a>
                                    <ul>
                                        <li><a href="hotel-details.html">Layout 1</a>
                                        </li>
                                        <li><a href="hotel-details-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="hotel-details-3.html">Layout 3</a>
                                        </li>
                                        <li><a href="hotel-details-4.html">Layout 4</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="hotel-payment.html">Payment</a>
                                    <ul>
                                        <li><a href="hotel-payment.html">Registered</a>
                                        </li>
                                        <li><a href="hotel-payment-registered-card.html">Existed Cards</a>
                                        </li>
                                        <li><a href="hotel-payment-unregistered.html">Unregistered</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="hotel-search.html">Search</a>
                                    <ul>
                                        <li><a href="hotel-search.html">Layout 1</a>
                                        </li>
                                        <li><a href="hotel-search-2.html">Layout 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="hotels.html">Results</a>
                                    <ul>
                                        <li><a href="hotels.html">Layout 1</a>
                                        </li>
                                        <li><a href="hotels-search-results-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="hotels-search-results-3.html">Layout 3</a>
                                        </li>
                                        <li><a href="hotels-search-results-4.html">Layout 4</a>
                                        </li>
                                        <li><a href="hotel-search-results-5.html">Layout 5</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="flights.html">Flights</a>
                            <ul>
                                <li><a href="flight-payment.html">Payment</a>
                                    <ul>
                                        <li><a href="flight-payment.html">Registered</a>
                                        </li>
                                        <li><a href="flight-payment-registered-card.html">Existed Cards</a>
                                        </li>
                                        <li><a href="flight-payment-unregistered.html">Unregistered</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="flight-search.html">Search</a>
                                    <ul>
                                        <li><a href="flight-search.html">Layout 1</a>
                                        </li>
                                        <li><a href="flight-search-2.html">Layout 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="flights.html">List</a>
                                    <ul>
                                        <li><a href="flights.html">Layout 1</a>
                                        </li>
                                        <li><a href="flights-search-results-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="flights-search-results-3.html">Layout 3</a>
                                        </li>
                                        <li><a href="flights-search-results-4.html">Layout 4</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="rentals.html">Rentals</a>
                            <ul>
                                <li><a href="rentals-details.html">Details</a>
                                    <ul>
                                        <li><a href="rentals-details.html">Layout 1</a>
                                        </li>
                                        <li><a href="rentals-details-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="rentals-details-3.html">Layout 3</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="rental-payment.html">Payment</a>
                                    <ul>
                                        <li><a href="rental-payment.html">Registered</a>
                                        </li>
                                        <li><a href="rental-payment-registered-card.html">Existed Cards</a>
                                        </li>
                                        <li><a href="rental-payment-unregistered.html">Unregistered</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="rentals-search.html">Search</a>
                                    <ul>
                                        <li><a href="rentals-search.html">Layout 1</a>
                                        </li>
                                        <li><a href="rentals-search-2.html">Layout 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="rentals.html">Results</a>
                                    <ul>
                                        <li><a href="rentals.html">Layout 1</a>
                                        </li>
                                        <li><a href="rentals-search-results-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="rentals-search-results-3.html">Layout 3</a>
                                        </li>
                                        <li><a href="rentals-search-results-4.html">Layout 4</a>
                                        </li>
                                        <li><a href="rentals-search-results-5.html">Layout 5</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="cars.html">Cars</a>
                            <ul>
                                <li><a href="car-details.html">Details</a>
                                </li>
                                <li><a href="car-payment.html">Payment</a>
                                    <ul>
                                        <li><a href="car-payment.html">Registered</a>
                                        </li>
                                        <li><a href="car-payment-registered-card.html">Existed Cards</a>
                                        </li>
                                        <li><a href="car-payment-unregistered.html">Unregistered</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="car-search.html">Search</a>
                                    <ul>
                                        <li><a href="car-search.html">Layout 1</a>
                                        </li>
                                        <li><a href="car-search-2.html">Layout 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="cars.html">Results</a>
                                    <ul>
                                        <li><a href="cars.html">Layout 1</a>
                                        </li>
                                        <li><a href="cars-results-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="cars-results-3.html">Layout 3</a>
                                        </li>
                                        <li><a href="cars-results-4.html">Layout 4</a>
                                        </li>
                                        <li><a href="cars-results-5.html">Layout 5</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="activities.html">Activities</a>
                            <ul>
                                <li><a href="activitiy-details.html">Details</a>
                                    <ul>
                                        <li><a href="activitiy-details.html">Layout 1</a>
                                        </li>
                                        <li><a href="activitiy-details-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="activitiy-details-3.html">Layout 3</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="activity-search.html">Search</a>
                                    <ul>
                                        <li><a href="activity-search.html">Layout 1</a>
                                        </li>
                                        <li><a href="activity-search-2.html">Layout 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="activitiy-payment.html">Payment</a>
                                    <ul>
                                        <li><a href="activitiy-payment.html">Registered</a>
                                        </li>
                                        <li><a href="activity-payment-registered-card.html">Existed Cards</a>
                                        </li>
                                        <li><a href="activitiy-payment-unregistered.html">Unregistered</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a href="activities.html">Results</a>
                                    <ul>
                                        <li><a href="activities.html">Layout 1</a>
                                        </li>
                                        <li><a href="activities-search-results-2.html">Layout 2</a>
                                        </li>
                                        <li><a href="activities-search-results-3.html">Layout 3</a>
                                        </li>
                                        <li><a href="activities-search-results-4.html">Layout 4</a>
                                        </li>
                                        <li><a href="activities-search-results-5.html">Layout 5</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </header>

        <div class="container">
            <h1 class="page-title">상품별 모음</h1>

        </div>
        <div>
        <ul class="nav nav-tabs" id="myTab">
            <li class="active"><a href="#tab-1" data-toggle="tab"><i class="fa fa-building-o"></i> <span>Hotels</span></a>
            </li>
            <li class=""><a href="#tab-2" data-toggle="tab"><i class="fa fa-plane"></i> <span>Flights</span></a>
            </li>
            <li class=""><a href="#tab-3" data-toggle="tab"><i class="fa fa-home"></i> <span>Rentals</span></a>
            </li>
            <li><a href="#tab-4" data-toggle="tab"><i class="fa fa-car"></i> <span>Cars</span></a>
            </li>
            <li class=""><a href="#tab-5" data-toggle="tab"><i class="fa fa-bolt"></i> <span>Activities</span></a>
            </li>
        </ul>
        <input class="btn btn-primary mt10" type="submit" value="정기예금">
        <input class="btn btn-primary mt10" type="submit" value="적금">
        <input class="btn btn-primary mt10" type="submit" value="은행">
        <input class="btn btn-primary mt10" type="submit" value="저축은행">
		<form action="/artclList">
			<input type="hidden" id="savingType" name="savingType" value="">
			<input type="hidden" id="bankType" name="bankType" value="">
			<input type="hidden" id="saveMoney" name="saveMoney" value="">
			
		</form>
         <div class="container">
            <div class="row">
            	<table id='dataTable' class='table table-bordered table-striped table-booking-history'>
            		<thead>
            			<tr>
            				<th>금융회사</th>
						    <th>상품명</th>
						    <th>가입개월</th>
						    <th>세전이자율</th>
						    <th>세후이자율</th>
						    <th>세후이자(예시)</th>
						    <th>최고 우대금리</th>
						    <th>이자계산방식</th>
            			</tr>
            		</thead>
            		<c:choose>
						<c:when test='${financeList!=null && fn:length(financeList)>0}'>
							<c:forEach var="finance" items="${financeList}" varStatus="stat">
								<tr>
							    	<td rowspan="${finance.optionCnt+1}">${finance.kor_co_nm}</td>
							    	<td rowspan="${finance.optionCnt+1}">${finance.fin_prdt_nm} <br/> (상세보기)</td>
							    	<c:choose>
								    	<c:when test='${finance.optionList!=null && fn:length(finance.optionList)>0}'>
											<c:forEach var="option" items="${finance.optionList}" varStatus="optionStat">
												<c:if test="${finance.fin_prdt_cd == option.fin_prdt_cd}">
											    	<tr>
											    		<td>${option.save_trm}개월</td>
											    		<td>${option.intr_rate}</td>
											    		<td>세후이자율</td>
											    		<td>세후받는금액</td>
											    		<td>${option.intr_rate2}</td>
											    		<td>${option.intr_rate_type_nm}</td>
											    	</tr>
										    	</c:if>
										    </c:forEach>
										</c:when>
										<c:otherwise>
											<td colspan="6">상품 옵션이없습니다.</td>
											<td>${finance.join_member}</td>
							    			<td>더보기</td>
										</c:otherwise>		
									</c:choose>
						    	</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td>
									데이터가 없습니다.
								</td> 
							</tr>
						</c:otherwise>
					</c:choose>
            	</table>
            	
            	
                <div id="table" class="col-md-12">
                   
                </div>
            </div>
        </div>
        
        <%-- <div class="container">
            <div class="row">
            	<table id='dataTable' class='table table-bordered table-striped table-booking-history'>
            		<thead>
            			<tr>
            				<th>금융회사</th>
						    <th>상품명</th>
						    <th>만기이자율</th>
						    <th>가입 방법</th>
						    <th>우대조건</th> 
						    <th>가입대상</th> 
						    <th>저축 금리유형명</th>
						    <th>저축 기간 [단위: 개월]</th>
						    <th>저축 금리 [소수점 2자리]</th>
						    <th>최고 우대금리 [소수점 2자리]</th>
            			</tr>
            		</thead>
            		<c:choose>
						<c:when test='${financeList!=null && fn:length(financeList)>0}'>
							<c:forEach var="finance" items="${financeList}" varStatus="stat">
								<tr>
							    	<td>${finance.kor_co_nm}</td>
							    	<td>${finance.fin_prdt_nm}</td>
							    	<td>${finance.mtrt_int}</td>
							    	<td>${finance.join_way}</td>
							    	<td>${finance.spcl_cnd}</td>
							    	<td>${finance.join_member}</td>
						    	
								<c:if test='${finance.optionList!=null && fn:length(finance.optionList)>0}'>
									<c:forEach var="option" items="${finance.optionList}" varStatus="stat">
										<c:if test="${finance.fin_prdt_cd == option.fin_prdt_cd}">
									    	<td>${option.intr_rate_type_nm}</td>
									    	<td>${option.save_trm}</td>
									    	<td>${option.intr_rate}</td>
									    	<td>${option.intr_rate2}</td>
								    	</c:if>
								    </c:forEach>
								</c:if>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td>
									데이터가 없습니다.
								</td> 
							</tr>
						</c:otherwise>
					</c:choose>
            	</table>
            	
            	
                <div id="table" class="col-md-12">
                   
                </div>
            </div>
        </div>--%>
        
        <div id="page"></div>
        
        <div class="gap"></div>
        <footer id="main-footer">
            <div class="container">
                <div class="row row-wrap">
                    <div class="col-md-3">
                        <a class="logo" href="index.html">
                            <img src="/Web-home/img/logo-invert.png" alt="Image Alternative text" title="Image Title" />
                        </a>
                        <p class="mb20">Booking, reviews and advices on hotels, resorts, flights, vacation rentals, travel packages, and lots more!</p>
                        <ul class="list list-horizontal list-space">
                            <li>
                                <a class="fa fa-facebook box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
                            </li>
                            <li>
                                <a class="fa fa-twitter box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
                            </li>
                            <li>
                                <a class="fa fa-google-plus box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
                            </li>
                            <li>
                                <a class="fa fa-linkedin box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
                            </li>
                            <li>
                                <a class="fa fa-pinterest box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-3">
                        <h4>Newsletter</h4>

                        <form>
                            <label>Enter your E-mail Address</label>
                            <input type="text" class="form-control">
                            <p class="mt5"><small>*We Never Send Spam</small>
                            </p>
                            <input type="submit" class="btn btn-primary" value="Subscribe">
                        </form>
                    </div>
                    <div class="col-md-2">
                        <ul class="list list-footer">
                            <li><a href="#">About US</a>
                            </li>
                            <li><a href="#">Press Centre</a>
                            </li>
                            <li><a href="#">Best Price Guarantee</a>
                            </li>
                            <li><a href="#">Travel News</a>
                            </li>
                            <li><a href="#">Jobs</a>
                            </li>
                            <li><a href="#">Privacy Policy</a>
                            </li>
                            <li><a href="#">Terms of Use</a>
                            </li>
                            <li><a href="#">Feedback</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-12">
                        <h4>Have Questions?</h4>

                        <h4><a href="#" class="text-color">hunecenter94@gmail.com</a></h4>

                        <p>COPYRIGHT(C) JHY. ALL RIGHTS RESERVED</p>
                    </div>

                </div>
            </div>
        </footer>

       
    </div>
</body>

</html>


