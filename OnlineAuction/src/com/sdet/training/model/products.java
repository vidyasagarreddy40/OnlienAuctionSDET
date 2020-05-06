package com.sdet.training.model;

public class products {
	
	private String productName;
	private String model;
	private char flag;
	public char getFlag() {
		return flag;
	}
	public void setFlag(char flag) {
		this.flag = flag;
	}
	public String getProductName() {
		return productName;
	}
	@Override
	public String toString() {
		return "products [productName=" + productName + ", model=" + model + "]";
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}
