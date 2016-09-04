package com.yc.picwatermark.service;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

/**
 * 添加水印的接口
 * @author navy
 */
public interface IWaterMarkService {
	public static final String MARK_TEXT="源辰信息";//水印文本
	public static final String FONT_NAME="微软雅黑";//水印字体
	public static final int FONT_STYLE=Font.BOLD;//字体
	public static final int FONT_SIZE=120;//字体大小 像素
	public static final Color FONT_COLOR=Color.green;//字体颜色
	public static final int X=10; //水印的X轴坐标
	public static final int Y=10; //水印的Y轴坐标
	public static float ALPHA=0.5F; //透明度
	
	public static final String LOGO="../logo/logo.gif";
	
	/**
	 * 添加水印
	 * @param pic:要添加水印的图片
	 * @param picFileName：图片的名称
	 * @param uploadPath：图片上传到相对路径
	 * @param realUploadPath：图片上传到绝对路径
	 * @return：添加完水印后的图片路径
	 */
	public String waterMark(File pic,String picFileName,String uploadPath,String realUploadPath);
}
