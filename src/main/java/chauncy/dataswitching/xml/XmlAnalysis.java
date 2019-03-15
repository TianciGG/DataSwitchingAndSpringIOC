package chauncy.dataswitching.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @classDesc: 功能描述(使用xml进行解析)
 * @author: ChauncyWang
 * @createTime: 2019年3月15日 上午11:11:57
 * @version: 1.0
 */
public class XmlAnalysis {
	static String FILENAME = "D:\\EclipseWorkspace\\EclipseMars2\\ArchitectFirstPhase\\DataSwitchingAndSpringIOC\\src\\main\\resources\\user.xml";

	public static void main(String[] args) throws DocumentException {
		// 获取xml解析器
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(new File(FILENAME));
		// 拿到根节点，只要拿到根节点子节点也会一并拿到
		Element rootElement = read.getRootElement();
		getNodes(rootElement);
	}

	static public void getNodes(Element rootElement) {
		System.out.println("节点名称：" + rootElement.getName());
		// 拿到节点属性
		List<Attribute> attributes = rootElement.attributes();
		for (Attribute attribute : attributes) {
			System.out.println("属性名称：" + attribute.getName() + "-------" + attribute.getText());
		}
		// 获取节点名称
		if (!rootElement.getTextTrim().equals("")) {
			System.out.println(rootElement.getName() + "------" + rootElement.getText());
		}
		// 返回下一个节点
		Iterator<Element> elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			// 获取当前节点值
			Element next = elementIterator.next();
			getNodes(next);
		}
	}
}
