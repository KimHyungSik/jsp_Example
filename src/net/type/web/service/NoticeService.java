package net.type.web.service;

import java.util.List;

import net.type.web.entity.Notice;

public class NoticeService {
	public List<Notice> getNOticeList() {

		return getNOticeList("title","",1);
	}

	public List<Notice> getNOticeList(int page) {

		return getNOticeList("title","",page);
	}

	public List<Notice> getNOticeList(String field, String query, int page) {

		return null;
	}

	//==================================================
	public int getNoticeCount() {

		return getNoticeCount("title", "", 1);
	}

	public int getNoticeCount(String field, String query, int page) {

		return 0;
	}

	//==================================================
	public Notice getNotice(int id) {
	
		return null;
	}
	
	public Notice getNextNotice(int id) {
		
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		
		return null;
	}
}
