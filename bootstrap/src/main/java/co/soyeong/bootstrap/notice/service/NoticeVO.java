package co.soyeong.bootstrap.notice.service;

public class NoticeVO {
	//이때 db col값이랑 vo객체 변수 명이 다르면 값을 가져 오지 못함
	private int nNo;
	private String nId;
	private String nName;
	private String nDate;
	private String nTitle;
	private String nSubject;
	private String nFileName;
	private String nPFileName;
	
	//여기에다 필요시 추가(ex,페이지 수)
	
	public int getnNo() {
		return nNo;
	}
	public void setnNo(int nNo) {
		this.nNo = nNo;
	}
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String getnDate() {
		return nDate;
	}
	public void setnDate(String nDate) {
		this.nDate = nDate;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnSubject() {
		return nSubject;
	}
	public void setnSubject(String nSubject) {
		this.nSubject = nSubject;
	}
	public String getnFileName() {
		return nFileName;
	}
	public void setnFileName(String nFileName) {
		this.nFileName = nFileName;
	}
	public String getnPFileName() {
		return nPFileName;
	}
	public void setnPFileName(String nPFileName) {
		this.nPFileName = nPFileName;
	}
	
}
