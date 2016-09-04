package com.yc.picwatermark.entity;

public class PicInfo {
	private String picPath;
	private String markTextPath;
	private String markImagePath;
	private String markTextMorePath;
	private String markImageMorePath;
	
	@Override
	public String toString() {
		return "PicInfo [picPath=" + picPath + ", markTextPath=" + markTextPath + ", markImagePath=" + markImagePath
				+ ", markTextMorePath=" + markTextMorePath + ", markImageMorePath=" + markImageMorePath + "]";
	}

	public PicInfo(String picPath, String markTextPath, String markImagePath, String markTextMorePath,
			String markImageMorePath) {
		super();
		this.picPath = picPath;
		this.markTextPath = markTextPath;
		this.markImagePath = markImagePath;
		this.markTextMorePath = markTextMorePath;
		this.markImageMorePath = markImageMorePath;
	}

	public PicInfo() {
		super();
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getMarkTextPath() {
		return markTextPath;
	}

	public void setMarkTextPath(String markTextPath) {
		this.markTextPath = markTextPath;
	}

	public String getMarkImagePath() {
		return markImagePath;
	}

	public void setMarkImagePath(String markImagePath) {
		this.markImagePath = markImagePath;
	}
	
	public String getMarkTextMorePath() {
		return markTextMorePath;
	}

	public void setMarkTextMorePath(String markTextMorePath) {
		this.markTextMorePath = markTextMorePath;
	}

	public String getMarkImageMorePath() {
		return markImageMorePath;
	}

	public void setMarkImageMorePath(String markImageMorePath) {
		this.markImageMorePath = markImageMorePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((markImageMorePath == null) ? 0 : markImageMorePath.hashCode());
		result = prime * result + ((markImagePath == null) ? 0 : markImagePath.hashCode());
		result = prime * result + ((markTextMorePath == null) ? 0 : markTextMorePath.hashCode());
		result = prime * result + ((markTextPath == null) ? 0 : markTextPath.hashCode());
		result = prime * result + ((picPath == null) ? 0 : picPath.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PicInfo other = (PicInfo) obj;
		if (markImageMorePath == null) {
			if (other.markImageMorePath != null)
				return false;
		} else if (!markImageMorePath.equals(other.markImageMorePath))
			return false;
		if (markImagePath == null) {
			if (other.markImagePath != null)
				return false;
		} else if (!markImagePath.equals(other.markImagePath))
			return false;
		if (markTextMorePath == null) {
			if (other.markTextMorePath != null)
				return false;
		} else if (!markTextMorePath.equals(other.markTextMorePath))
			return false;
		if (markTextPath == null) {
			if (other.markTextPath != null)
				return false;
		} else if (!markTextPath.equals(other.markTextPath))
			return false;
		if (picPath == null) {
			if (other.picPath != null)
				return false;
		} else if (!picPath.equals(other.picPath))
			return false;
		return true;
	}
}
