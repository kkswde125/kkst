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
   *{
      padding : 0;
      margin : 0;
   }
   img{
      width: 300px;
      height: 200px;
      }   
   #form{
      width: 600px;
      height: 240px;
   }
      
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

<%!
   int count=0;
%>

	$(window).

   function load() {
      
      for (var i = 2; i < 16; i++) {
         $("#tab"+i).hide();
      }
      
      var arrayT=null;
      var arrayH=null;
      

      
   }
   function restart(){
         
      for (var i = 0; i < 16; i++) {
         $(".td"+i).show();
      }
      for (var i = 2; i < 16; i++) {
         $("#tab"+i).hide();
      }
      }
   
   function clickings(i,seq) {
      
      //0 , 짝수 일때 i+2 or i+3
      // 홀수 일때 i+1 or i+2
         
      if (i==0||i%2==0) {
         $(".td"+i).hide();
         $(".td"+(i+1)).hide();
         $("#tab"+(i+2)).show();
         $("#tab"+(i+3)).show();

         
        
        arrayT=[];
         
         arrayT.push(seq);
         alert("짝수배열:"+arrayT);
 
         
         
      }      
      else if(i==1||i%2==1){
         $(".td"+(i-1)).hide();
         $(".td"+i).hide();
         $("#tab"+(i+1)).show();
         $("#tab"+(i+2)).show();
         
         arrayH=[];
         
         arrayH.push(seq);
         
         alert("홀수 배열:"+arrayH);
      
      }
   }
   
</script>
</head>

<body onload="load()">

<div id="form">
<table>
<tr>
         <%
            for (int i = 0; i < lists.size(); i++) {
         %>
         <td class="td<%=i%>">
            <table id="tab<%=i%>">
               <tr>
                  <td onclick="clickings(<%=i%>,<%=lists.get(i).getSeq()%>)">
                     <div id="choice<%=i%>">
                        <img src="img/food1.jpg" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td>
                     <div id="name<%=i%>">
                        <%=lists.get(i).getName()%>
                     </div>
                  </td>
               </tr>
            </table> <%
      } // for
%>
         </td>

      </tr>
   
</table>
</div>
<input type="button" value="다시하기" onclick="restart()">

</body>
</html>