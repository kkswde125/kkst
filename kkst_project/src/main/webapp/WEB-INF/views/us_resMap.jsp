<%@page import="com.pro.kkst.dtos.ResDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<% 
@SuppressWarnings("unchecked")
List<ResDto> lists =(List<ResDto>)request.getAttribute("lists");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
      <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=dxAelTQKShNPGfu0KuVB&submodules=geocoder"></script>
</head>
<body>
    <div id="map" style="width:100%;height:400px;"></div>
	<script>
	
	
	
	 var cSize=100;
	    function go100() {
			cSize=100;
		}
	    
	    function go500() {
			cSize=500;
		}
	    
	    function go1000() {
			cSize=1000;
		}
	    
	    
	      var map = new naver.maps.Map('map');
	
	      
	      var str = '';
	      var menuLayer = $('<div style="position:absolute;z-index:10000;background-color:#fff;border:solid 1px #333;padding:10px;display:none;"></div>');
	      map.getPanes().floatPane.appendChild(menuLayer[0]);
	   
	      
	      
	      
	      
	   naver.maps.Event.addListener(map, 'rightclick', function(e) {
	    	  
// 	          var coordHtml = 'Coord: '+ e.coord +'<br />Point: '+ e.point +'<br />Offset: '+ e.offset;
// 	          menuLayer.show().css({
// 	              left: e.offset.x,
// 	              top: e.offset.y
// 	          }).html(coordHtml);
	          
	          var info = new naver.maps.InfoWindow({		
	        	  content:'<div style="width:150px;text-align:center;padding:10px;">현재위치가 여기신가요?</div>'
				});
	          
	          var markerz = new naver.maps.Marker({
	              position: e.coord,
	              map: map
	          });
	          
	          info.open(map,markerz);
	          
			str=e.coord.toString();
			
			
			var strAry= str.split(':');
		      var strX = strAry[1].split(',')[0];
		      var strY = strAry[2].split(')')[0];
//	 	      alert(strX+','+strY);
		      var newCenter = new naver.maps.LatLng(strX,strY);

		      map.setCenter(newCenter);
		      
		      
		      var circlez = new naver.maps.Circle({
	      	    map: map,
	      	    center: newCenter,
	      	    radius: cSize,
	      	    fillColor: 'crimson',
	      	    fillOpacity: 0.2
	      	});
		      
		      
		      
	        var miniXz = circlez.getBounds().minX();
	        var miniYz = circlez.getBounds().minY();
	        var maxiXz = circlez.getBounds().maxX();
	        var maxiYz = circlez.getBounds().maxY();
	        var miniz = new naver.maps.Point(miniXz,miniYz);
	        var maxiz = new naver.maps.Point(maxiXz,maxiYz);
	        
	      	  
	        var cboundsz= new naver.maps.PointBounds(miniz,maxiz);
	        
	        
// 	        var rectangle2 = new naver.maps.Rectangle({
// 	      	  map:map,
// 	      	  bounds: cboundsz
// 	        });
	       
	        var name1=[]; //상호명
			 var markers=[]; // 마커 배열
			 var infoWindows=[]; //정보창
	      
	      

	      <%
	      	for(int i=0; i< lists.size(); i++){
	      %>
	      
	      var pp<%=i%> = new naver.maps.LatLng(<%=lists.get(i).getX()%>,<%=lists.get(i).getY()%>);	      
	      
			if(cboundsz.hasPoint(pp<%=i%>)){
	
			name1.push("<%=lists.get(i).getName()%>");
				
			
			var marker = new naver.maps.Marker({
    		position: pp<%=i%>,
   			 map: map
 			 });
			
			markers.push(marker);
			
			}	      
			
	        <%
	      	}
	      %>
			
			
			
	 
			 for (var j = 0; j < name1.length; j++) {
					
					var infoWindow = new naver.maps.InfoWindow({
						content:'<div style="width:150px;text-align:center;padding:10px;">'+name1[j]+'</div>'
					});
				
				alert(name1);
// 				alert(name[j]);
				infoWindows.push(infoWindow);
				alert(infoWindows);

			 }	
			 
		      	naver.maps.Event.addListener(map,'click',function(e){
		      		circlez.setVisible(false);
		      		markerz.setVisible(false);
		      		info.close();
		      	for (var i = 0; i < markers.length; i++) {
					
		      		if(markers!=null){
		      			
		      			info.close();
			      		markers[i].setVisible(false);
			      		infoWindows[i].close();
		      		}
				}	
							
		      
		      	});
			 
			 
			 
			 
				function getClickHandler(seq) {
				    return function(e) {
				        var marker = markers[seq];
				        var infoWindow1 = infoWindows[seq];

// 				        if (infoWindow.getMap()) {
// 				            infoWindow.close();
// 				        } else {
				            infoWindow1.open(map, marker);
// 				        }
				    }
				}
				
				
				for (var i=0, ii=markers.length; i<=ii; i++) {
					naver.maps.Event.addListener(markers[i],'click',getClickHandler(i));
					}
			

	
// 				map.getMap(map);
	      
	      
	      });
	      
	     
	      
	</script>
	
	  <button onclick="go100()">100m</button>
      <button onclick="go500()">500m</button>
      <button onclick="go1000()">1000m</button>

</body>
</html>