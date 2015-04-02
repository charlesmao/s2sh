package com.bufoon.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import sun.misc.BASE64Encoder;


/**
 * 通用工具类
 * @author maozy
 *
 */
public class Util {

	/**
	 * 对字符串进行MD5加密 
	 * @param str
	 * @return
	 */
	public static String md5Encryption(String str) {
		String newStr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base = new BASE64Encoder();
			newStr = base.encode(md5.digest(str.getBytes("UTF-8")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newStr;
	}
	
	public static boolean isNull(String str) {
		if (str != null && !str.trim().equals("")) {  
            return false;  
        } else {  
            return true;  
        }  
	}
}
