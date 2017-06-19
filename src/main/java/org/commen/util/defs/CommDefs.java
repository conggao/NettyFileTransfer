package org.commen.util.defs;

public class CommDefs {

	public  static final String   FILE_SERVER_URL_ROOT = "http://fitboard.com.cn:8000/newres";
	public static final String    SERVER_HOMEPAGE_URL                   = "http://fitboard.com.cn:18080/FitConWeb";

	public static final String    PASSWORD_FOR_MD5_KEY                  = "a!#@!$1f";

	public static final Integer   WEB_LIST_DEFAULT_PAGE_SELECT_LENTH    = 15;
	
	
	
	public static final Integer   WEB_LIST_TOP_PAGE_SELECT_LENTH        = 10;

	public static final Integer   APP_LIST_DEFAULT_PAGE_SELECT_LENTH    = 6;

	public  static final String DIR_RES_ROOT         = "/var/www/newres";

	public  static final String DIR_TEMPLATE_ROOT    = "/var/www/newres/template";
	
	public  static final String DIR_USER_ROOT    = "/user";
	

	public static final Integer     SMS_VERIFICATION_CODE_TYPE_LOGIN            = 0x01;
	public static final Integer     SMS_VERIFICATION_CODE_TYPE_RESETPASSWORD    = 0x02;
	public static final Integer     SMS_VERIFICATION_CODE_TYPE_REG              = 0x11;


	public static final String    THUMB_PIC_FILE_NAME_SUFFIX  = "thumb1900";
	public static final Integer   THUMB_PIC_SIZE_SMALL        = 60;    // 生成一张60*60的缩略图
	public static final Integer   THUMB_PIC_SIZE_MEDIUM       = 120;   // 生成一张120*120的缩略图
	public static final Integer   THUMB_PIC_SIZE_LARGE        = 200;   // 生成一张200*Y的缩略图，Y值为比例值
	public static final Integer   THUMB_PIC_SIZE_HUGE         = 320;   // 生成一张320*Y的缩略图，Y值为比例值

}
