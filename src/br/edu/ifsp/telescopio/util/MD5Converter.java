package br.edu.ifsp.telescopio.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Converter {
	public static String convertToMd5(String str) {
    	
	       MessageDigest m = null;
	       
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	       m.update(str.getBytes(),0,str.length());
	       return new BigInteger(1,m.digest()).toString();
	    }
}
