package chauncy.dataswitching;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSON {
	static String jsonStr = "{\"user\":[{\"name\":\"小红\",\"sex\":\"女\"},{\"name\":\"小黑\",\"sex\":\"男\"}]}";

	public static void main(String[] args) {
		//1.将json字符串转换成jsonObject
		JSONObject jsonObject = new JSONObject();
		//json对象
		JSONObject parseObject = jsonObject.parseObject(jsonStr);
		//获取json数组对象
		JSONArray jsonArray = parseObject.getJSONArray("user");
		for (Object object : jsonArray) {
			JSONObject jsonObject=(JSONObject) object;
			
		}
	}
}
