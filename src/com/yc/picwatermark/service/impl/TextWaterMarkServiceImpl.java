package com.yc.picwatermark.service.impl;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.yc.picwatermark.service.IWaterMarkService;

/**
 * 添加文本水印
 * @author navy
 */
public class TextWaterMarkServiceImpl implements IWaterMarkService{
	@Override
	public String waterMark(File pic, String picFileName, String uploadPath, String realUploadPath) {
		FileOutputStream fos=null; //将内存中的图片写出到磁盘
		String newFileName = ""; //添加水印后的图片
		
		try {
			Image image=ImageIO.read(pic); //获取图片信息
			int width=image.getWidth(null);//获取图片的大小
			int height=image.getHeight(null);//获取图片的大小
			
			//1.创建图片缓存对象   高度、宽度和图片颜色
			BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			
			//2.创建Java绘图工具对象
			Graphics2D gp=bufferedImage.createGraphics();
			
			/*
			 * 3.使用绘图工具对象将原图绘制到缓存图片对象
			 * 绘制图片  要绘制的图片对象 绘制的开始坐标(跟原图一样，所以都是0)
			 * 绘制图片的高度和宽度
			 */
			gp.drawImage(image,0,0,width,height,null);
			
			//4.添加文字水印
			//(1)设置显示文本的样式
			gp.setFont(new Font(FONT_NAME,FONT_STYLE,FONT_SIZE));
			//(2)设置显示文本的颜色
			gp.setColor(FONT_COLOR);
			
			//(3)计算文本的显示位置
			int x=width-FONT_SIZE*getTextLength(MARK_TEXT);
			int y=height-FONT_SIZE;
			
			//(4)设置透明度
			gp.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,ALPHA));
			
			//(5)绘制文本水印
			gp.drawString(MARK_TEXT,x,y+FONT_SIZE);
			
			//(6)释放工具
			gp.dispose();
			
			
			//5.创建图像编码工具类，对图片对象进行编码处理  JPEGImageEncoder
			newFileName="text_"+picFileName;
			fos=new FileOutputStream(realUploadPath+"/"+newFileName);
			JPEGImageEncoder jie=JPEGCodec.createJPEGEncoder(fos);
			//6.使用图像编码工具类，输出缓存图像到目标图片文件
			jie.encode(bufferedImage);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			//7.关闭流
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return uploadPath+"/"+newFileName;
	}
	
	/**
	 * 计算文本的长度
	 * 如果是中文则就是文本长度值，如果是英文或数字，则是一半其长度的一半
	 * 两个英文的长度跟一个汉字的长度一样
	 * @param text：要计算的文本
	 * @return
	 */
	public int getTextLength(String text){
		int length=text.length(); 
		String temp;
		for(int i=0;i<text.length();i++){
			temp=String.valueOf(text.charAt(i));
			if(temp.getBytes().length>1){ //如果是汉字，则加1
				length++;
			}
		}
		length=length%2==0?length/2:length/2+1;
		return length;
	} 
}
