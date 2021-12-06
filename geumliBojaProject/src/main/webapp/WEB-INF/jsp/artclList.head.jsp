<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
 <meta name="keywords" content="Template, html, premium, themeforest" />
 <meta name="description" content="Traveler - Premium template for travel companies">
 <meta name="author" content="Tsoy">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">

 <!-- GOOGLE FONTS -->
 <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700' rel='stylesheet' type='text/css'>
 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600' rel='stylesheet' type='text/css'>
 <!-- /GOOGLE FONTS -->
 <link rel="stylesheet" href="/Web-home/css/bootstrap.css">
 <link rel="stylesheet" href="/Web-home/css/font-awesome.css">
 <link rel="stylesheet" href="/Web-home/css/icomoon.css">
 <link rel="stylesheet" href="/Web-home/css/styles.css">
 <link rel="stylesheet" href="/Web-home/css/mystyles.css">
 <script src="/Web-home/js/modernizr.js"></script>

  <script src="/Web-home/js/jquery.js"></script>
  <script src="/Web-home/js/bootstrap.js"></script>
  <script src="/Web-home/js/slimmenu.js"></script>
  <script src="/Web-home/js/bootstrap-datepicker.js"></script>
  <script src="/Web-home/js/bootstrap-timepicker.js"></script>
  <script src="/Web-home/js/nicescroll.js"></script>
  <script src="/Web-home/js/dropit.js"></script>
  <script src="/Web-home/js/ionrangeslider.js"></script>
  <script src="/Web-home/js/icheck.js"></script>
  <script src="/Web-home/js/fotorama.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
  <script src="/Web-home/js/typeahead.js"></script>
  <script src="/Web-home/js/card-payment.js"></script>
  <script src="/Web-home/js/magnific.js"></script>
  <script src="/Web-home/js/owl-carousel.js"></script>
  <script src="/Web-home/js/fitvids.js"></script>
  <script src="/Web-home/js/tweet.js"></script>
  <script src="/Web-home/js/countdown.js"></script>
  <script src="/Web-home/js/gridrotator.js"></script>
  <script src="/Web-home/js/custom.js"></script>
  

<script>
$(document).ready(function(){
	var url = "/getJsonData";
	var html = "";
	var pageHtml = "";
	$.ajax({
		type:"post",
		url:url,
		sync:false,
		cache:false,
		success:function(data){
			var obj = JSON.parse(data);
			var page = obj.total_count/10;
			html += "<table class='table table-bordered table-striped table-booking-history'>";
			html += "<thead>";
			html += "<tr>";
		    html += "<th>금융회사</th>";
		    html += "<th>상품명</th>";
		    html += "<th>만기이자율</th>";
		    html += "<th>가입 방법</th>";
		    html += "<th>우대조건</th>"; 
		    html += "<th>가입대상</th>"; 
		    html += "<th>저축 금리유형</th>";
		    html += "<th>저축 금리유형명</th>";
		    html += "<th>저축 기간 [단위: 개월]</th>";
		    html += "<th>저축 금리 [소수점 2자리]</th>";
		    html += "<th>최고 우대금리 [소수점 2자리]</th>";
		    html += "</tr>";
		    html += "</thead>";
		    var baseList = obj.baseList;
			html +="<tbody>";
			
		    for(var i=0; i<53; i++){
		    	html +="<tr>";
		    	html +="<td>"+baseList[i].kor_co_nm+"</td>";
		    	html +="<td>"+baseList[i].fin_prdt_nm+"</td>";
		    	html +="<td>"+baseList[i].mtrt_int+"</td>";
		    	html +="<td>"+baseList[i].join_way+"</td>";
		    	html +="<td>"+baseList[i].spcl_cnd+"</td>";
		    	html +="<td>"+baseList[i].join_member+"</td>";

		    	/*html +="<td>"+baseList[i].optionList[i].intr_rate_type+"</td>";
		    	html +="<td>"+baseList[i].optionList[i].intr_rate_type_nm+"</td>";
		    	html +="<td>"+baseList[i].optionList[i].save_trm+"</td>";
		    	html +="<td>"+baseList[i].optionList[i].intr_rate+"</td>";
		    	html +="<td>"+baseList[i].optionList[i].intr_rate2+"</td>";*/
		    	html +="</tr>";
			}
		    html +="</tbody>";
			html += "</table>";
			//$("#table").append(html);
			for(var j=1; j<page; j++){
				pageHtml +="<a href='javascript:page("+j+");'>"+j+"</a>";
			}
			//$("#page").append(pageHtml);
		}
		
	});	
});


 //페이지 번호 클릭
 function page(page) { 
	var url = "/getJsonData";
	var html = "";
	var pageHtml = "";
	$.ajax({
		type:"POST",
		url:url,
		sync:false,
		data:{"page":page},
		cache:false,
		success:function(data){
			var obj = JSON.parse(data);
			var idxSize = page*10;
			$("#dataTable").remove();
			html += "<table id='dataTable' class='table table-bordered table-striped table-booking-history'>";
			html += "<thead>";
			html += "<tr>";
		    html += "<th>금융회사</th>";
		    html += "<th>상품명</th>";
		    html += "<th>만기이자율</th>";
		    html += "<th>가입 방법</th>";
		    html += "<th>우대조건</th>"; 
		    html += "<th>가입대상</th>"; 
		    html += "</tr>";
		    html += "</thead>";
		    var baseList = obj.baseList;
			html +="<tbody>";
			if(baseList.length>0){
			    for(var i=0; i<idxSize; i++){
			    	html +="<tr>";
			    	html +="<td>"+baseList[i].kor_co_nm+"</td>";
			    	html +="<td>"+baseList[i].fin_prdt_nm+"</td>";
			    	html +="<td>"+baseList[i].mtrt_int+"</td>";
			    	html +="<td>"+baseList[i].join_way+"</td>";
			    	html +="<td>"+baseList[i].spcl_cnd+"</td>";
			    	html +="<td>"+baseList[i].join_member+"</td>";
			    	html +="</tr>";
				}
		    	html +="</tbody>";
				html += "</table>";
			}else{
				
				html+="<tr><td colspan='6'>데이터가 없습니다</td></tr>"
			}
			$("#table").append(html);
		}
		
	});	
	
 }
</script>