onmessage=function(e){
	var b=new Date().getTime();
	while(true){
		var n=new Date().getTime();
		if(n-b>=3000){
			postMessage("load")
			b=n;
		}
	}
}