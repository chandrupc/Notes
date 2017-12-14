package org.orphane.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CKUtil {

	public static void addCookie(HttpServletResponse response,HttpServletRequest request,String userName){
		Cookie cookie = new Cookie("auth_key",userName);
		//cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
	}
	
	
	public static boolean checkCookie(HttpServletRequest request, HttpServletResponse response,String userName){
		boolean status = false;
		try {
			Cookie[] cookies = request.getCookies();
			for(Cookie each : cookies){
				if(each.getName().equals("auth_key")){
					if(each.getValue().equals(userName)){
						status = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	 
	public static void clearCookie(HttpServletRequest request,HttpServletResponse response,String username){
		Cookie cookie = new Cookie("auth_key", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
}
