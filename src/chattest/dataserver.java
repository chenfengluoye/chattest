package chattest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class dataserver extends HttpServlet {
	
	/**
	 * 与数据机器交互的接口，获取传送过来的数据（全为表单数据）
	 * <br>url:/chattest/server
	 * @param swich 开关状态（已打开，已关闭）
	 * @param nowtime 当前时间，格式如下HH:mm:ss,例如23:15:14
	 * @param nowOdata 当前氧气值，字符串就行，不带单位
	 * @param nowTdata 当前温度值，字符串就行，不带单位
	 * <br>成功返回格式：{"result":true}
	 * <br>失败返回格式：{"result":false,"reason":"数据不全"}
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try{
			resp.setContentType("text/html;charset=utf-8");
			String swich =req.getParameter("data");
			String nowtime=req.getParameter("nowtime");
			String nowOdata=req.getParameter("nowOdata");
			String nowTdata=req.getParameter("nowTdata");
			JSONObject re=new JSONObject();
				if(swich==null||nowtime==null||nowOdata==null||nowTdata==null){
					re.put("result", false);
					re.put("reason", "数据不全");
					resp.getWriter().print(re.toString());
					return;
				}else{
					data.datas.put("swich", swich);
					data.datas.put("nowtime", nowtime);
					data.datas.put("nowOdata", nowOdata);
					data.datas.put("nowTdata", nowTdata);
					String[] date=(String[]) data.datas.get("date");
					String[] Odata=(String[]) data.datas.get("Odata");
					String[] Tdata=(String[]) data.datas.get("Tdata");
					date[date.length]=nowtime;
					Odata[Odata.length]=nowOdata;
					Tdata[Tdata.length]=nowTdata;
					re.put("result", true);
					resp.getWriter().print(re.toString());
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
