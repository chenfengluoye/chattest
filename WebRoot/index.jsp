<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	
	<script src="./js/Chart.js"></script>
    <script src="./js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/mains.css" />
    <script type="text/javascript">
    
    window.onload=function(){

      getdata("/chattest/server");
    	var wk=new Worker("./js/work.js");
    	wk.onmessage=function(e){
    
    		getdata("/chattest/server");
    	}
    	wk.onerror=function(e){
    	
    		alert(e.message)
    	}
    	
    	wk.postMessage("start");
    }
    </script>
  </head>
  
  <body>
   <canvas id="myChart" width="400px" height="150px" style="padding-right: 20px;"></canvas>
   <canvas id="myChart1" width="400px" height="150px" style="padding-right: 20px;"></canvas>
   <canvas id="myChart2" width="400px" height="150px" style="padding-right: 20px;"></canvas>
   <div style="width: 100%;">
   <div style="width: 100%;height:80px;"></div>
  		<div id="time" class="mydiv" style="background-color:#409EAA"></div>
   		<div id="yangqi" class="mydiv" style="background-color:#67C23A"></div>
   		<div id="wendu" class="mydiv" style="background-color:#E6A23C"></div>
   		<div id="swich" class="mydiv" style="background-color:#F56C6C"></div>
   </div>
  </body>
</html>
