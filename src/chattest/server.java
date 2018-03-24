package chattest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * 与客户端交互的接口
 * @author chengkaiju
 *
 */
public class server extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		if(data.datas.get("date")==null||data.datas.get("Tdata")==null||data.datas.get("Odata")==null){
			JSONObject o=new JSONObject();
			String[] Odata=new String[100];
			String[] Tdata=new String[100];
			String[] date=new String[100];
			for(int i=0;i<100;i++){
				Odata[i]=String.valueOf((int) (Math.random()*100));
				Tdata[i]=String.valueOf((Math.random()*100)) ;
				SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//�������ڸ�ʽ
				date[i]=df.format(new Date());
			}
			o.put("swich", "已打开");
			o.put("nowtime",date[99]);
			o.put("nowOdata",Odata[99]);
			o.put("nowTdata",Tdata[99]);
			o.put("date", date);
			o.put("Odata", Odata);
			o.put("Tdata", Tdata);
			resp.getWriter().print(o.toString());
		}
		else{
			resp.getWriter().print(data.datas.toString());
		}
		
	}

}
