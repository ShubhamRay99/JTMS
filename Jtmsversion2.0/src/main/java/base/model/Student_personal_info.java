package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student_personal_info {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long personal_id;
	private String name;
	private String branch;
	private String college;
	@Column(nullable = false,unique = true)
	private String email;
	private Long phone;
	private Integer yop;
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Long getPersonal_id() {
		return personal_id;
	}
	public void setPersonal_id(Long personal_id) {
		this.personal_id = personal_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Integer getYop() {
		return yop;
	}
	public void setYop(Integer yop) {
		this.yop = yop;
	}
	
	
}
