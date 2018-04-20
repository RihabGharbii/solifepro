package com.example.demo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Result implements Serializable{
	
	private Long revision;
	private String autheur;
	private Date date;
	private String message;
	private List<String> path;
	public Long getRevision() {
		return revision;
	}
	public void setRevision(Long revision) {
		this.revision = revision;
	}
	public String getAutheur() {
		return autheur;
	}
	public void setAutheur(String autheur) {
		this.autheur = autheur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getPath() {
		return path;
	}
	public void setPath(List<String> path) {
		this.path = path;
	}
	public Result(Long revision, String autheur, Date date, String message, List<String> path) {
		super();
		this.revision = revision;
		this.autheur = autheur;
		this.date = date;
		this.message = message;
		this.path = path;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
