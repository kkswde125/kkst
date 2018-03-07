<%@page import="com.pro.kkst.dtos.menuDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<% 
List<menuDto> lists = (List<menuDto>)request.getAttribute("lists");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	img{
		width: 300px;
		height: 200px;
		}	
		
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

<%!
	int count=0;
%>
	
	
	
	
	
	
	function load() {
		
		for (var i = 2; i <=15; i++) {
		$("#choice"+i).css("display","none");
		}
		for (var i = 2; i <=15; i++) {
		$("#name"+i).css("display","none");
		}
		
// 		$("#choice0").css("display", "block");
// 		$("#choice1").css("display", "block");
	}
	
	
	function clickings(i) {
		
		//0 , 짝수 일때 i+2 or i+3
		// 홀수 일때 i+1 or i+2
		
		
		//6, 7
		
		if(i==0){
			$("#choice"+i).css("display","none"); //0
			$("#choice"+i+1).css("display","none"); //1 
			$("#name"+i).css("display","none"); // 
			$("#name"+i+1).css("display","none");
			
			
			
			
			$("#choice"+(i+2)).css("display","block");
			$("#choice"+(i+3)).css("display","block");
			$("#name"+(i+2)).css("display","block");
			$("#name"+(i+2)).css("display","block");
		}
		
		if(i==1){
			$("#choice"+i).css("display","none");
			$("#choice"+i+1).css("display","none");
			$("#name"+i).css("display","none");
			$("#name"+i).css("display","none");	
				
			
			$("#choice"+(i+1)).css("display","block");
			$("#choice"+(i+2)).css("display","block");
			$("#name"+(i+1)).css("display","block");
			$("#name"+(i+2)).css("display","block");
		}
		
		
		if (i%2==0) {
			
			$("#choice"+i).css("display","none");
			$("#choice"+i+1).css("display","none");
			$("#name"+i).css("display","none");
			$("#name"+i+1).css("display","none");
			
			
			
			
			$("#choice"+(i+2)).css("display","block");
			$("#choice"+(i+3)).css("display","block");
			$("#name"+(i+2)).css("display","block");
			$("#name"+(i+3)).css("display","block");
			
		}
		
		else if(i%3==0){
			
		$("#choice"+i).css("display","none");
		$("#choice"+i+1).css("display","none");
		$("#name"+i).css("display","none");
		$("#name"+i+1).css("display","none");	
			
		
		$("#choice"+(i+1)).css("display","block");
		$("#choice"+(i+2)).css("display","block");
		$("#name"+(i+1)).css("display","block");
		$("#name"+(i+2)).css("display","block");
	
		}
	}
	
	
	
		
// 		function olympic(seq) {
		
		
// 		location.href="kkstController.do?command=olympic&seq="+seq;
		
// 		}

		
// 		function olympic1(seq) {
// 			location.href="kkstController.do?command=winner&seq="+seq;
			
// 			}


</script>
</head>

<body onload="load()">
<h1></h1>
<table>
<tr>
	<%
		for(int i=0; i<lists.size(); i++){
	%>
	
	<td>
<table>

	<tr>

	
		<td >
		
		<div  id ="choice<%=i%>" onclick="clickings(<%=i%>)" >
		<img src="img/food1.jpg"/>
		</div>
		</td>

		</tr>

	<tr>
		
		<td>
		<div id ="name<%=i%>">
		<%=lists.get(i).getName()%>
		</div>
		</td>
	</tr>


</table>
		
					

<%
		} // for
%>	
</td>

	</tr>
	
</table>

</body>
</html>