package cn.itcast.domain;

public class Manager {
	private Long manager_id;
	private String manager_num;
	private String manager_name;
	private String enter_time;
	private String email;
	private String sex;
	private String tel;
	public Long getManager_id() {
		return manager_id;
	}
	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_num() {
		return manager_num;
	}
	public void setManager_num(String manager_num) {
		this.manager_num = manager_num;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(String enter_time) {
		this.enter_time = enter_time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "Manager [manager_id=" + manager_id + ", manager_num=" + manager_num + ", manager_name=" + manager_name
				+ ", enter_time=" + enter_time + ", email=" + email + ", sex=" + sex + ", tel=" + tel + "]";
	}
	
}
