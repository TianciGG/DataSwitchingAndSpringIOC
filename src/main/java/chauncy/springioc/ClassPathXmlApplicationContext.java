package chauncy.springioc;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import chauncy.reflect.entity.UserEntity;

/**
 * @classDesc: 功能描述(Spring加载过程/SpringIOC底层代码实现)
 * @author: ChauncyWang
 * @createTime: 2019年3月15日 下午4:07:02
 * @version: 1.0
 */
public class ClassPathXmlApplicationContext {
	private String xmlPath;

	public ClassPathXmlApplicationContext(String xmlPath) {
		this.xmlPath = xmlPath;
	}

	public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, NoSuchFieldException,
			SecurityException, InstantiationException, IllegalAccessException {
		// 1.读取xml配置文件
		// 获取XML解析器
		SAXReader saxReader = new SAXReader();
		// 获取当前项目路径
		Document read = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(xmlPath));
		// 获取根节点对象
		Element rootElement = read.getRootElement();
		List<Element> elements = rootElement.elements();
		Object obj = null;
		for (Element sonEle : elements) {
			String sonBeanId = sonEle.attributeValue("id");
			if (!sonBeanId.equals(beanId)) {
				continue;
			}
			// 2.获取到每个bean的配置 获取class地址
			String beanClassPath = sonEle.attributeValue("class");
			// 3.拿到class地址进行反射实例化对象，使用反射api为私有属性赋值
			Class<?> forName = Class.forName(beanClassPath);
			obj = forName.newInstance();
			// 拿到类的成员变量
			List<Element> grandSonElement = sonEle.elements();
			for (Element element : grandSonElement) {
				String name = element.attributeValue("name");
				String value = element.attributeValue("value");
				// 使用反射api为私有属性赋值
				Field declaredField = forName.getDeclaredField(name);
				// 允许往私有成员赋值
				declaredField.setAccessible(true);
				declaredField.set(obj, value);
			}

		}
		return obj;
	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			InstantiationException, IllegalAccessException, DocumentException {
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object bean = application.getBean("user1");
		UserEntity user = (UserEntity) bean;
		System.out.println(user.getUserId() + "----" + user.getUserName());
	}
}
