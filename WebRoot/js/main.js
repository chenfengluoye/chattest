
var nowtime=new Date().getDate();
var nowOdata=0;
var nowTdata=0;
var swich="未知";

function getdata(url){
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		var jsondata=JSON.parse(xmlhttp.responseText);
		nowtime=jsondata.nowtime;
		nowOdata=jsondata.nowOdata;
		nowTdata=jsondata.nowTdata;
		swich=jsondata.swich;
		//x轴的数据
	    var xdata=jsondata.date;
		//y轴的数据
	    var Tdata=jsondata.Tdata;
	    var Odata=jsondata.Odata;
	    finadraw(xdata,Tdata,Odata);
	}
	xmlhttp.open("get", url);
	xmlhttp.send();
}


//绘制曲线
function draw(id,title,xdata,datasets){
    	try{
			var options={
        		scales: {
           	 		yAxes: [{
                		ticks: {
                   		beginAtZero:true
                		}
            		}]
        		},
        		title: {
        			display: true,
        	        text: title,
        			fontSize:'60'
                }
    		};
    		var data={"labels": xdata,"datasets": datasets};
    		var paintdata={type: 'line',data: data,options: options};
			var ctx = document.getElementById(id).getContext('2d');
			var myChart = new Chart(ctx,paintdata);
		}catch(err){
			alert(err)
		}
    }

//获取某一种数据及其样式
function getdataitem(ylabel,ydata,bodercolor,bgcolor){
    var dataitem={
            		"label": ylabel,
           			"data": ydata,
            		"fill": true,
            		"backgroundColor":bgcolor,
            		"borderColor": bodercolor,
            		"lineTension": 0.1
        		};
    return dataitem;
}

//代码使用示例
function finadraw(xdata,Tdata,Odata){
	
	
	var T=getdataitem("温度值",Tdata,'rgb(255, 159, 64)','rgba(255, 159, 64, 0.2)');
	var O=getdataitem("氧气值",Odata,'rgb(75, 192, 192)','rgba(75, 192, 192,0.2)');
	
	//画温度曲线
	var datasets=new Array();
	datasets.push(T);
	draw("myChart","温度变化曲线",xdata,datasets)
	
	//画氧气曲线
	var datasets1=new Array();
	datasets1.push(O);
	draw("myChart1","氧气变化曲线",xdata,datasets1)
	
	//画混合曲线
	var datasets2=new Array();
	datasets2.push(O);
	datasets2.push(T);
	draw("myChart2","氧气-温度混合曲线",xdata,datasets2);
	
	
	var time=document.getElementById("time");
	var yangqi=document.getElementById("yangqi");
	var wendu=document.getElementById("wendu");
	var kaiguan=document.getElementById("swich");
	time.innerHTML="当前时间："+nowtime;
	yangqi.innerHTML="当前氧气值: "+nowOdata;
	wendu.innerHTML="当前温度值："+nowTdata;
	kaiguan.innerHTML="开关状态："+swich;
}