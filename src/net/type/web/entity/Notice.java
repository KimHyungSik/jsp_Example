package net.type.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private Date reg_date;
	private String writer_id;
	private int hit;
	private String content;
	
	public Notice() {}

	public Notice(int id, String title, Date reg_date, String writer_id, int hit, String content) {
		super();
		this.id = id;
		this.title = title;
		this.reg_date = reg_date;
		this.writer_id = writer_id;
		this.hit = hit;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", reg_date=" + reg_date + ", writer_id=" + writer_id
				+ ", hit=" + hit + ", content=" + content + "]";
	}

	
}
