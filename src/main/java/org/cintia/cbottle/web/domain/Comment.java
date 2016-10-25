package org.cintia.cbottle.web.domain;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Comment {
	
	private String commentId;
	private String productId;
	private String email;
	private Date date;
	private String text;
	
	public Comment(String commentId, String productId, String email, Date date, String text) {
		this.commentId = commentId;
		this.productId = productId;
		this.email = email;
		this.date = date;
		this.text = text;
	}
	
	public String getCommentId() {
		return commentId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getText() {
		return text;
	}
}
