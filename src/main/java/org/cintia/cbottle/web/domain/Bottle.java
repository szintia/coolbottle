package org.cintia.cbottle.web.domain;

import java.math.BigDecimal;
import java.sql.Date;


public class Bottle {
	
	private String productId;
	private String categoryId;
	private String productName;
	private String description;
	private BigDecimal price;
	private int amount;
	private Date date;
	
	public Bottle() {}
	
	public Bottle(String productId, String categoryId, String name, String desc, BigDecimal price, int amount, Date date) {
		this.productId = productId;
		this.categoryId = categoryId;
		productName = name;
		description = desc;
		this.price = price;
		this.date = date;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date2) {
		this.date = date2;
	}
}
