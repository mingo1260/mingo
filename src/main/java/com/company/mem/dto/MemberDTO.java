package com.company.mem.dto;

public class MemberDTO {
	private String mbId;
	private String mbPw;
	private String mbName;
	private String mbBirth;
	private String mbGender;
	private String mbPhone;
	private String mbEmail;
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public String getMbPw() {
		return mbPw;
	}
	public void setMbPw(String mbPw) {
		this.mbPw = mbPw;
	}
	public String getMbName() {
		return mbName;
	}
	public void setMbName(String mbName) {
		this.mbName = mbName;
	}
	public String getMbBirth() {
		return mbBirth;
	}
	public void setMbBirth(String mbBirth) {
		this.mbBirth = mbBirth;
	}
	public String getMbGender() {
		return mbGender;
	}
	public void setMbGender(String mbGender) {
		this.mbGender = mbGender;
	}
	public String getMbPhone() {
		return mbPhone;
	}
	public void setMbPhone(String mbPhone) {
		this.mbPhone = mbPhone;
	}
	public String getMbEmail() {
		return mbEmail;
	}
	public void setMbEmail(String mbEmail) {
		this.mbEmail = mbEmail;
	}
	@Override
	public String toString() {
		return "MemberDTO [mbId=" + mbId + ", mbPw=" + mbPw + ", mbName=" + mbName + ", mbBirth=" + mbBirth
				+ ", mbGender=" + mbGender + ", mbPhone=" + mbPhone + ", mbEmail=" + mbEmail + "]";
	}

}
