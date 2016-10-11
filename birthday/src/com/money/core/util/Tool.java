package com.money.core.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.money.xfgl.user.entity.User;

public class Tool {
	// 写入XML文件
	public static void updateUser(List<User> list) {
		String xmlString = "";
		String filePath = "D:\\apache-tomcat-7.0.70\\webapps\\birthday\\xml\\user.xml";
		FileOutputStream fos = null;
		try {
			xmlString += "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
			xmlString += "<users>";
			for (User u : list) {
				String gender = u.isGender() ? "男" : "女";
				xmlString += "<user>";
				xmlString += "<id>" + u.getId() + "</id>";
				xmlString += "<name>" + u.getName() + "</name>";
				xmlString += "<gender>" + gender + "</gender>";
				xmlString += "<mobile>" + u.getMobile() + "</mobile>";
				xmlString += "<birthday>" + u.getBirthday() + "</birthday>";
				xmlString += "<address>" + u.getAddress() + "</address>";
				xmlString += "<memo>" + u.getMemo() + "</memo>";
				xmlString += "</user>";
			}
			xmlString += "</users>";
			byte[] xmlByte = xmlString.getBytes("UTF-8");
			fos = new FileOutputStream(filePath);
			fos.write(xmlByte);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
