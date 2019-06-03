package com.mail.sender.application.controller.mail;

import java.util.List;

public class Email {
	public Email(String from, List<String> to, List<String> cc, String subject, String message, boolean isHtml,
			String imagePath) {
		super();
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.message = message;
		this.isHtml = isHtml;
		this.imagePath = imagePath;
	}

	private String from;

	private List<String> to;

	private List<String> cc;

	private String subject;

	private String message;
	
	private boolean isHtml;
	
	private String imagePath;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
