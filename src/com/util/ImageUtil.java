package com.util;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.CosNaming.BindingIterator;

public class ImageUtil {
	//获取图片
	public void getImageByUrl(String image_url) throws Exception {
		//new一个url对象
		URL url = new URL(image_url);
		//打开链接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		//设置请求方式为"GET"
		connection.setRequestMethod("GET");
		
		//超时响应时间设备为5秒
		connection.setConnectTimeout(5*1000);
		
		//通过输入流获取图片数据
		InputStream inputStream = connection.getInputStream();
		
		//得到图片的二进制数据，以二进制封装得到数据，具有通用性
		byte[] data = readInputStream(inputStream);
		
		//new一个文件对象来保存图片，默认保存当前工程目录
		String save_url = PropertyUtil.getProperty("save_url");
		File imageFile = new File("image/image.jpg");
		//创建输出流
		FileOutputStream outputStream = new FileOutputStream(imageFile);
		
		//写入数据
		outputStream.write(data);
		
		outputStream.close();
	}

	private byte[] readInputStream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		//创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		//每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		//使用一个输入流从buffer里面把数据读出来
		while((len = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer,0,len);
		}
		//关闭输入流
		inputStream.close();
		return outputStream.toByteArray();
	}

}
