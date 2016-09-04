package com.yc.picwatermark.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadUtil {
	/**
	 * 图片上传
	 * @param pic：要上传的图片
	 * @param picFileName：要上传的图片名称
	 * @param uploadPath：要上传的图片路径
	 * @param realUploadPath：要上车的图片绝对路径
	 * @return
	 * @throws IOException 
	 */
	public String uploadPic(File pic,String picFileName,String uploadPath,String realUploadPath) throws IOException{
		InputStream is = new FileInputStream(pic);  
		OutputStream os = new FileOutputStream(new File(realUploadPath,picFileName));  

		byte[] buf = new byte[1024];  
		int length = 0 ;  

		while(-1 != (length = is.read(buf) )){  
			os.write(buf, 0, length) ;  
		}  
		is.close();  
		os.close();  
		return uploadPath+"/"+picFileName;
	}
}
