package com.test.util;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlUtil {

    public static Map<String, String> xmlToJson(String msg) {
        SAXReader reader = new SAXReader();
        Map<String,String> map = new HashMap<>();
        try {
            Document document = reader.read(new ByteArrayInputStream(msg.getBytes("UTF-8")));
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList) {
                System.out.println(e.getName() + "|" + e.getText());
                map.put(e.getName(), e.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    public static JSONObject xmlToJsonObj(String msg) {
        SAXReader reader = new SAXReader();
        JSONObject json = new JSONObject();
        try {
            Document document = reader.read(new ByteArrayInputStream(msg.getBytes("UTF-8")));
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList) {
                System.out.println(e.getName() + "|" + e.getText());
                json.put(e.getName(), e.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
