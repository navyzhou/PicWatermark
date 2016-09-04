package com.yc.picwatermark.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yc.picwatermark.entity.PicInfo;
import com.yc.picwatermark.service.IWaterMarkService;
import com.yc.picwatermark.service.impl.ImageMoreWaterMarkServiceImpl;
import com.yc.picwatermark.service.impl.ImageWaterMarkServiceImpl;
import com.yc.picwatermark.service.impl.TextMoreWaterMarkServiceImpl;
import com.yc.picwatermark.service.impl.TextWaterMarkServiceImpl;
import com.yc.picwatermark.utils.UploadUtil;

@SuppressWarnings("serial")
public class WaterMarkAction extends ActionSupport{
	private List<File> file;
	private List<String> fileFileName;  
	private List<String> fileContentType;
	//接受依赖注入的属性
	private String savePath;
	
	private List<PicInfo> picInfos=new ArrayList<PicInfo>();
	
	public List<File> getFile() {  
		return file;  
	}  

	public void setFile(List<File> file) {  
		this.file = file;  
	}  

	public List<String> getFileFileName() {  
		return fileFileName;  
	}  

	public void setFileFileName(List<String> fileFileName) {  
		this.fileFileName = fileFileName;  
	} 

	public List<String> getFileContentType() {  
		return fileContentType;  
	}  

	public void setFileContentType(List<String> fileContentType) {  
		this.fileContentType = fileContentType;  
	}  
	
	/**
	 * 返回上传文件的保存位置
	 * @return
	 */
	public String getSavePath() throws Exception{
		//return ServletActionContext.getServletContext().getRealPath(savePath); 
		return savePath; 
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String watermark() throws Exception{  
		//获取文件存储路径  
		String path =ServletActionContext.getServletContext().getRealPath(savePath);
		File fls=new File(path);
		if(!fls.exists()){
			fls.mkdirs();
		}
		
		PicInfo picInfo;
		UploadUtil upload=new UploadUtil();
		String picPath;
		
		IWaterMarkService waterTextMark=new TextWaterMarkServiceImpl();
		String markTextPath;
		
		IWaterMarkService waterImageMark=new ImageWaterMarkServiceImpl();
		String markImagePath;
		
		IWaterMarkService waterTextMoreMark=new TextMoreWaterMarkServiceImpl();
		String markTextMorePath;
		
		IWaterMarkService waterImageMoreMark=new ImageMoreWaterMarkServiceImpl();
		String markImageMorePath;
		
		for(int i=0; i<file.size();i++){
			picPath=upload.uploadPic(file.get(i),fileFileName.get(i),savePath, path);
			picInfo=new PicInfo();
			picInfo.setPicPath(picPath);
			
			markTextPath=waterTextMark.waterMark(file.get(i),fileFileName.get(i),savePath, path);
			picInfo.setMarkTextPath(markTextPath);
			
			
			markImagePath=waterImageMark.waterMark(file.get(i),fileFileName.get(i),savePath, path);
			picInfo.setMarkImagePath(markImagePath);
			
			markTextMorePath=waterTextMoreMark.waterMark(file.get(i),fileFileName.get(i),savePath, path);
			picInfo.setMarkTextMorePath(markTextMorePath);
			
			markImageMorePath=waterImageMoreMark.waterMark(file.get(i),fileFileName.get(i),savePath, path);
			picInfo.setMarkImageMorePath(markImageMorePath);
			
			picInfos.add(picInfo);
		}  
		return SUCCESS;  
	}

	public List<PicInfo> getPicInfos() {
		return picInfos;
	}

	public void setPicInfos(List<PicInfo> picInfos) {
		this.picInfos = picInfos;
	}
}
