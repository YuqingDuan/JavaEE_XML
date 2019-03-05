package parse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/*
XML解析方式(面试常问)
        有很多种，但是常用的有两种。
        * DOM
        * SAX

        针对这两种解析方式的API
        一些组织或者公司， 针对以上两种解析方式， 给出的解决方案有哪些？
        jaxp  sun公司。 比较繁琐
        jdom
        dom4j  使用比较广泛
*/
public class Dom4j {
    public static void main(String[] args) {
        // try {
        //     // 1.创建sax读取对象
        //     SAXReader saxReader = new SAXReader();
        //     // 2.指定解析的xml源
        //     Document document = saxReader.read(new File("src/xml/stus.xml"));
        //     // 3.得到元素
        //     // 得到根元素<stus>
        //     Element rootElement = document.getRootElement();
        //     // 获取根元素下面的所有子元素, 即所有<stu>
        //     List<Element> elements = rootElement.elements();
        //     // 遍历所有的stu元素
        //     for (Element elem : elements) {
        //         // 获取name元素的内容
        //         String name = elem.element("name").getText();
        //         // 获取age元素的内容
        //         String age = elem.element("age").getText();
        //         // 获取address元素的内容
        //         String address = elem.element("address").getText();
        //         System.out.println("name: " + name + ", age: " + age + ", address: " + address);
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // Xpath
        try {
            // 1.创建sax读取对象
            SAXReader saxReader = new SAXReader();
            // 2.指定解析的xml源
            Document document = saxReader.read(new File("src/xml/stus.xml"));
            // 3.得到元素
            // 得到根元素<stus>
            Element rootElement = document.getRootElement();
            // 使用Xpath表达式获取根元素下面的第一个<name>子元素
            Element nameElement = (Element) rootElement.selectSingleNode("//name");
            System.out.println(nameElement.getText());
            System.out.println("-------------------");

            // 获取文档里面的所有name元素
            List<Element> names = rootElement.selectNodes("//name");
            // 遍历所有的stu元素
            for (Element name : names) {
                System.out.println(name.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
