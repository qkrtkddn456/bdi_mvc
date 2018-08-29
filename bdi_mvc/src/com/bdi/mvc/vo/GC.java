package com.bdi.mvc.vo;

public class GC {
	private int gcnum;
	private String gcname;
	private int gcprice;
	private String gcvendor;
	private int gcorder;
	private String gcdesc;
	private String gcimg;
	public GC() {}
	public GC(int gcnum, String gcname, int gcprice, String gcvendor, int gcorder, String gcdesc, String gcimg) {
		super();
		this.gcnum = gcnum;
		this.gcname = gcname;
		this.gcprice = gcprice;
		this.gcvendor = gcvendor;
		this.gcorder = gcorder;
		this.gcdesc = gcdesc;
		this.gcimg = gcimg;
	}
	public int getGcnum() {
		return gcnum;
	}
	public void setGcnum(int gcnum) {
		this.gcnum = gcnum;
	}
	public String getGcname() {
		return gcname;
	}
	public void setGcname(String gcname) {
		this.gcname = gcname;
	}
	public int getGcprice() {
		return gcprice;
	}
	public void setGcprice(int gcprice) {
		this.gcprice = gcprice;
	}
	public String getGcvendor() {
		return gcvendor;
	}
	public void setGcvendor(String gcvendor) {
		this.gcvendor = gcvendor;
	}
	public int getGcorder() {
		return gcorder;
	}
	public void setGcorder(int gcorder) {
		this.gcorder = gcorder;
	}
	public String getGcdesc() {
		return gcdesc;
	}
	public void setGcdesc(String gcdesc) {
		this.gcdesc = gcdesc;
	}
	public String getGcimg() {
		return gcimg;
	}
	public void setGcimg(String gcimg) {
		this.gcimg = gcimg;
	}
	@Override
	public String toString() {
		return "GC [gcnum=" + gcnum + ", gcname=" + gcname + ", gcprice=" + gcprice + ", gcvendor=" + gcvendor
				+ ", gcorder=" + gcorder + ", gcdesc=" + gcdesc + ", gcimg=" + gcimg + "]";
	}
	
}
