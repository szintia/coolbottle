package org.cintia.cbottle.web.domain;

import java.math.BigDecimal;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Bottle {
	
	private String productId;
	private String categoryId;
	private String productName;
	private String description;
	private BigDecimal price;
	private int amount;
	private Date date;
	
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
	
	public String getCategoryId() {
		return categoryId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Date getDate() {
		return date;
	}
}
