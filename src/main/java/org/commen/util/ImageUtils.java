package org.commen.util;

import org.commen.util.defs.CommDefs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;




public class ImageUtils {


    

    public static String inThumbnailImage(String imagePath, String dstFilePath, int w, int h, Byte scaleType)
    {
    	if (null == imagePath || null == dstFilePath)
    	{
    		return null;
    	}
    	
        String fileSuffix  = FileMgtUtils.getFileSuffix(imagePath);

    	File fileDst = new File(dstFilePath);;
        if(fileDst.exists())
        {
        	return dstFilePath;
        }
        
    	File imgFile = new File(imagePath);
        if(imgFile.exists())
        {
            try
            {
                String types = Arrays.toString(ImageIO.getReaderFormatNames());
                
                if(fileSuffix == null || types.toLowerCase().indexOf(fileSuffix.toLowerCase()) < 0)
                {                    
                	return imagePath;
                }

                Image img    = ImageIO.read(imgFile);
                int   width  = img.getWidth(null);
                int   height = img.getHeight(null);
                switch (scaleType) 
                {
					case 1:
					{
                        h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
						break;
					}
					case 2:
					{
                        w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
						break;
					}
					default:
					{
						break;
					}
					
				}
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                
                ImageIO.write(bi, 
                		fileSuffix, 
                		new File(dstFilePath));
                return dstFilePath;
            } 
            catch (IOException e) 
            {
            }
        }
        else
        {
        }
        return null;
    }

    public static String inThumbnailImage(String imagePath, int w, int h, Byte scaleType)
    {
        String dstFilePath = getThumbFileName(imagePath, w, h);

        return inThumbnailImage(imagePath, dstFilePath, w, h, scaleType);
    }
    
    public static String thumbnailImage(String imagePath, int w, int h, Byte scaleType){
        return inThumbnailImage(imagePath, w, h, scaleType);
    }
    
    
    public static String thumbnailImage(String imagePath, int w, int h){
        return thumbnailImage(imagePath, w, h, (byte) 0);
    }


    public static String thumbnailImage(String imagePath, Integer size)
    {
        return thumbnailImage(imagePath, size, size, (byte) 0);
    }
    public static String thumbnailImage(String imagePath, Integer size, Byte scaleType)
    {
        return thumbnailImage(imagePath, size, size, scaleType);
    }


    public static String getThumbFileName(String fileName, int w, int h)
    {
        String filePath    = FileMgtUtils.getFilePath(fileName);
        String fileTitle   = FileMgtUtils.getFileTitle(fileName);
        String fileSuffix  = FileMgtUtils.getFileSuffix(fileName);
        
		if (filePath != null && fileTitle != null && fileSuffix != null)
		{
			String dstPath = String.format("%s/%s_%s.%s", 
					filePath, 
					fileTitle,
					CommDefs.THUMB_PIC_FILE_NAME_SUFFIX,
					fileSuffix);
			return dstPath;
		}
        return null;
    }

    public static String getThumbFileName(String fileName, Integer size)
    {
    	return getThumbFileName(fileName, size, size);
    }
}