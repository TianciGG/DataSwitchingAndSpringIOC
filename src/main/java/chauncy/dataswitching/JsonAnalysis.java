package chauncy.dataswitching;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @classDesc: 功能描述:(fastjson 解析)
 * @author: ChauncyWang
 * @createTime: 2019年3月15日 上午12:01:46
 * @verssion: v1.0
 */
public class JsonAnalysis {
	static String JSONSTR = "{\"user\":[{\"name\":\"小红\",\"sex\":\"女\"},{\"name\":\"小黑\",\"sex\":\"男\"}]}";

	public static void main(String[] args) {
		//1.将json字符串转换成jsonObject
		JSONObject jsonObject = new JSONObject();
		//json对象
		JSONObject parseObject = jsonObject.parseObject(JSONSTR);
		//获取json数组对象
		JSONArray jsonArray = parseObject.getJSONArray("user");
		for (Object object : jsonArray) {
			JSONObject jo=(JSONObject) object;
			//不要使用强转String的方法，因为fastjsonAPI中有getString方法
			String name=jo.getString("name");
			String sex=jo.getString("sex");
			System.out.println(name+"---------"+sex);
		}
	}
}
