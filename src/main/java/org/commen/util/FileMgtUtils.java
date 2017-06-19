package org.commen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class FileMgtUtils
{
    public static final String           FILE_SUFFIX_VEDIO   = "avi mpeg mpg wmv mkv rmvb mp4 ts mov 3gp vob asf rm flv";
    public static final String           FILE_SUFFIX_VOICE   = "wav mid midi wma mp3";
    public static final String           FILE_SUFFIX_IMAGE   = "bmp jpg jpeg gif png wmf";
    public static final String           FILE_SUFFIX_FLASH   = "swf";
    public static final String           FILE_SUFFIX_PPT     = "ppt pptx";
    public static final String           FILE_SUFFIX_DOC     = "doc docx";
    public static final String           FILE_SUFFIX_EXCEL   = "xls xlsx";
    public static final String           FILE_SUFFIX_TXT     = "txt";
    public static final String           FILE_SUFFIX_PDF     = "pdf";
    public static final String           FILE_SUFFIX_ZIP     = "zip rar";
    public static final String           FILE_SUFFIX_WBD     = "wbd";
    
    public static final int              FILE_TYPE_UNKNOWN   = 0;
	public static final int              FILE_TYPE_FILE      = 1;
	public static final int              FILE_TYPE_DIR       = 2;
	public static final int              FILE_TYPE_VEDIO     = 11;
	public static final int              FILE_TYPE_VOICE     = 12;
	public static final int              FILE_TYPE_IMAGE     = 13;
	public static final int              FILE_TYPE_FLASH     = 14;
	public static final int              FILE_TYPE_PPT       = 15;
	public static final int              FILE_TYPE_DOC       = 16;
	public static final int              FILE_TYPE_EXCEL     = 17;
	public static final int              FILE_TYPE_TXT       = 18;
	public static final int              FILE_TYPE_PDF       = 19;
	public static final int              FILE_TYPE_ZIP       = 20;
	public static final int              FILE_TYPE_WB        = 21;
	public static final int              FILE_TYPE_DICTATION = 22;
	

	public static boolean copyFile(String oldPath, String newPath) 
	{   
	    try 
	    {   
            int bytesum = 0;   
            int byteread = 0;   
            File oldfile = new File(oldPath);   
            if (oldfile.exists()) { //鏂囦欢瀛樺湪鏃�  
                InputStream inStream = new FileInputStream(oldPath); //璇诲叆鍘熸枃浠�  
                FileOutputStream fs = new FileOutputStream(newPath);   
                byte[] buffer = new byte[1444];   
                int length;   
                while ( (byteread = inStream.read(buffer)) != -1) {   
                    bytesum += byteread; //瀛楄妭鏁�鏂囦欢澶у皬   
                    System.out.println(bytesum);   
                    fs.write(buffer, 0, byteread);   
                }   
                inStream.close();
                return true;
            }   
	    }   
	    catch (Exception e)
	    {   
	        e.printStackTrace();   	  
	    }   
	    return false;
	  
	}   	

	public static void deleteFile(File file) 
	{
		if (file.exists())
		{ // 鍒ゆ柇鏂囦欢鏄惁瀛樺湪
			if (file.isFile())
			{ // 鍒ゆ柇鏄惁鏄枃浠�
			    file.delete(); // delete()鏂规硶 浣犲簲璇ョ煡閬�鏄垹闄ょ殑鎰忔�;
			} 
//		else if (file.isDirectory())
//		{ // 鍚﹀垯濡傛灉瀹冩槸涓�釜鐩綍
//		File files[] = file.listFiles(); // 澹版槑鐩綍涓嬫墍鏈夌殑鏂囦欢 files[];
//		for (int i = 0; i < files.length; i++) 
//		{ // 閬嶅巻鐩綍涓嬫墍鏈夌殑鏂囦欢
//		this.deleteFile(files[i]); // 鎶婃瘡涓枃浠�鐢ㄨ繖涓柟娉曡繘琛岃凯浠�
//		}
//		}
//		file.delete();
		}
		else
		{
		}
	}
	

	public static void deleteAllFile(File file) 
	{
		if (file.exists())
		{ // 鍒ゆ柇鏂囦欢鏄惁瀛樺湪
			if (file.isFile())
			{ // 鍒ゆ柇鏄惁鏄枃浠�
			    file.delete(); // delete()鏂规硶 浣犲簲璇ョ煡閬�鏄垹闄ょ殑鎰忔�;
			} 
		else if (file.isDirectory())
		{ // 鍚﹀垯濡傛灉瀹冩槸涓�釜鐩綍
		File files[] = file.listFiles(); // 澹版槑鐩綍涓嬫墍鏈夌殑鏂囦欢 files[];
		for (int i = 0; i < files.length; i++) 
		{ // 閬嶅巻鐩綍涓嬫墍鏈夌殑鏂囦欢
		deleteAllFile(files[i]); // 鎶婃瘡涓枃浠�鐢ㄨ繖涓柟娉曡繘琛岃凯浠�
		}
		}
		file.delete();
		}
		else
		{
		}
	}
	 
    public static String getSubString(String fullPathName, int start, int end)
    {		
		if(start != -1 && end != -1)
		{
			return fullPathName.substring(start, end);	
		}
		else
		{
			return null;
		}			
	}    
    
    private static int getEndMarkIndex(String fullPathName)
    {
        int end   = fullPathName.lastIndexOf("/");
        if (-1 == end)
        {
            end   = fullPathName.lastIndexOf("\\");
            if (-1 == end)
            {
                end = fullPathName.length();
            }
        }
        return end;
    }
    
    public static String getFileName(String fullPathName)
    {		
		int start = getEndMarkIndex(fullPathName);
		int end   = fullPathName.length();
		return getSubString(fullPathName, start + 1, end);
	}    
    
    public static String getFileTitle(String fullPathName)
    {		
        int start = getEndMarkIndex(fullPathName);
		int end   = fullPathName.lastIndexOf(".");
		return getSubString(fullPathName, start + 1, end);
	}    
    
    public static String getFileSuffix(String fullPathName)
    {		
		int start = fullPathName.lastIndexOf(".");
		return getSubString(fullPathName, start + 1, fullPathName.length());
	}    
    
    public static String getFilePath(String fullPathName)
    {		
        int end = getEndMarkIndex(fullPathName);
		return getSubString(fullPathName, 0, end);
	}


	public static int getFileType(String strFileName)
	{
		if (-1 == strFileName.lastIndexOf("."))
		{
	    	return FILE_TYPE_DIR;
		}
		
	    String strSuffix = getFileSuffix(strFileName);
	    if (FILE_SUFFIX_VEDIO.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_VEDIO;
	    }
	    else if (FILE_SUFFIX_VOICE.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_VOICE;
	    }
	    else if (FILE_SUFFIX_IMAGE.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_IMAGE;
	    }
	    else if (FILE_SUFFIX_FLASH.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_FLASH;
	    }
	    else if (FILE_SUFFIX_PPT.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_PPT;
	    }
	    else if (FILE_SUFFIX_DOC.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_DOC;
	    }
	    else if (FILE_SUFFIX_EXCEL.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_EXCEL;
	    }
	    else if (FILE_SUFFIX_TXT.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_TXT;
	    }
	    else if (FILE_SUFFIX_PDF.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_PDF;
	    }
	    else if (FILE_SUFFIX_ZIP.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_ZIP;
	    }
	    else if (FILE_SUFFIX_WBD.indexOf(strSuffix) > 0)
	    {
	    	return FILE_TYPE_WB;
	    }
	    return FILE_TYPE_UNKNOWN;
	}
	  
	  public static long getFileSize(File file) throws Exception {
		  long size = 0;
		  if (file.exists()) {
		   FileInputStream fis = null;
		   fis = new FileInputStream(file);
		   size = fis.available();
		  } else {
		   file.createNewFile();
		  }
		  return size;
		 }
	  
 }
