package com.bdi.sp.vo;

public class Us {

	private Integer usno;
	private String usid;
	private String uspwd;
	private String usname;
	private String usemail;
	private String usaddress;
	private String ustel;
	private String usgender;
	private String ushobby;
	private String usrecommender;
	public String getUsid() {
		return usid;
	}
	public void setUsid(String usid) {
		this.usid = usid;
	}
	public Integer getUsno() {
		return usno;
	}
	public void setUsno(Integer usno) {
		this.usno = usno;
	}
	public String getUspwd() {
		return uspwd;
	}
	public void setUspwd(String uspwd) {
		this.uspwd = uspwd;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getUsemail() {
		return usemail;
	}
	public void setUsemail(String usemail) {
		this.usemail = usemail;
	}
	public String getUsaddress() {
		return usaddress;
	}
	public void setUsaddress(String usaddress) {
		this.usaddress = usaddress;
	}
	public String getUstel() {
		return ustel;
	}
	public void setUstel(String ustel) {
		this.ustel = ustel;
	}
	public String getUsgender() {
		return usgender;
	}
	public void setUsgender(String usgender) {
		this.usgender = usgender;
	}
	public String getUshobby() {
		return ushobby;
	}
	public void setUshobby(String ushobby) {
		this.ushobby = ushobby;
	}
	public String getUsrecommender() {
		return usrecommender;
	}
	public void setUsrecommender(String usrecommender) {
		this.usrecommender = usrecommender;
	}
	@Override
	public String toString() {
		return "Us [usno=" + usno + ", usid=" + usid + ", uspwd=" + uspwd + ", usname=" + usname + ", usemail="
				+ usemail + ", usaddress=" + usaddress + ", ustel=" + ustel + ", usgender=" + usgender + ", ushobby="
				+ ushobby + ", usrecommender=" + usrecommender + "]";
	}
	
	
}