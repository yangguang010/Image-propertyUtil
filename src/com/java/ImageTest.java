package com.java;

import com.util.ImageUtil;

public class ImageTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String image_url = "http://img.hexun.com/2011-06-21/130726386.jpg";
		ImageUtil imageUtil = new ImageUtil();
		imageUtil.getImageByUrl(image_url);
	}
}
