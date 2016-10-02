package traning.parsers.dom.execute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.tc.les03.entity.Document;
import by.tc.les03.entity.MyElement;
import by.tc.les03.service.impl.BaseDomParser;
import by.tc.les03.service.impl.DomFactory;

public class DomExecute {
	public static void main(String[] args) {
		DomFactory factory = DomFactory.getInstance();
		BaseDomParser domParser = (BaseDomParser) factory.create();
		
		try {
			domParser.parse("src/res/web.xml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		
		Document document = domParser.getDocument();
		MyElement root = document.getRoot();
		System.out.println("Имя корневого элемента: " + root.getName());

		document.getAllElemens();

		List<MyElement> arrElem = new ArrayList<MyElement>();

		arrElem = document.getElementsByTagName("welcome-file");
		for (MyElement my : arrElem) {
			System.out.println("Имя элемента: " + " " + my.getName() + " "
					+ "Текст: " + my.getDescription() + " " + "Имя родителя: "
					+ my.getParent().getName());
		}

		MyElement parent = document.getParentByTagName("welcome-file");
		System.out.println(parent.getName());

		document.getAttributesByElementName("welcome-file");

		List<MyElement> childs = new ArrayList<MyElement>();
		childs = document.getChildsByElementName("web-app");
		System.out.println("Для web-app дочерние элементы:");
		for (MyElement my : childs) {
			System.out.println("Имя дочернего элемента: " + " " + my.getName());
		}

		System.out.println("Hallo");
	}
	}

