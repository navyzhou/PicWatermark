图片水印的实现思路：
	1.创建缓存图片对象   BufferedImage
	2.创建Java绘图工具对象  Graphics2D
	3.使用绘图工具对象将原图绘制到缓存图片对象
	4.使用绘图工具将水印绘制到缓存图片对象，此时图片还在内存中，无法使用
	5.创建图像编码工具类，对图片对象进行编码处理  JPEGImageEncoder
	6.使用图像编码工具类，输出缓存图像到目标图片文件
	

框架搭建：
	1.依赖包
		commons-fileupload-1.2.1.jar
		commons-io-1.3.2.jar
		commons-logging-1.1.jar
		freemarker-2.3.13.jar
		ognl-2.6.11.jar
		struts2-core-2.1.6.jar
		xwork-2.1.2.jar
		
	2.web.xml中添加struts2的过滤器
	
	3.创建struts.xml文件