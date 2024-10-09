package com.user.dto;

public class UpdatePwd {
	
	private Integer id;
	private String oldPwd;
	private String newPwd;
	private String confirmPwd;
	
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UpdatePwd() {
		super();
	}
	
	public UpdatePwd(String oldPwd, String newPwd, String confirmPwd) {
		super();
		this.oldPwd = oldPwd;
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
	}
	public UpdatePwd(Integer id,String oldPwd, String newPwd, String confirmPwd) {
		super();
		this.id=id;
		this.oldPwd = oldPwd;
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
	}
	@Override
	public String toString() {
		return "UpdatePwd [id=" + id + ", oldPwd=" + oldPwd + ", newPwd=" + newPwd + ", confirmPwd=" + confirmPwd + "]";
	}
	
}
