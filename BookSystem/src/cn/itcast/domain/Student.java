package cn.itcast.domain;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private Long stu_id;
	private String stu_num;
	private String stu_name;
	private String credit_id;
	private String academy;
	private String profession;
	private String class_name;
	private String sex;
	private String tel;
	private String email;
	private String enter_time;
	private Set<Borrow> borrows = new HashSet<Borrow>();
	
	public Long getStu_id() {
		return stu_id;
	}
	public void setStu_id(Long stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_num() {
		return stu_num;
	}
	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(String enter_time) {
		this.enter_time = enter_time;
	}
	public Set<Borrow> getBorrows() {
		return borrows;
	}
	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}
}
