package chauncy.dataswitching.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @classDesc: 功能描述:(组装json)
 * @author: ChauncyWang
 * @createTime: 2019年3月15日 上午12:27:52
 * @verssion: v1.0
 */
public class JsonAssemble {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject bean1=new JSONObject();
		bean1.put("name", "小红");
		bean1.put("sex", "女");
		jsonArray.add(bean1);
		JSONObject bean2=new JSONObject();
		bean2.put("name", "小黑");
		bean2.put("sex", "男");
		jsonArray.add(bean2);
		jsonObject.put("user", jsonArray);
		System.out.println(jsonObject.toJSONString());
		
	}
}
