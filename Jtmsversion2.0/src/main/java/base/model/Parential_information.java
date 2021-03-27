package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Parential_information {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long parent_id;
	@Column(name = "student_id",nullable = false,unique = true)
	private Long studentId;
	private String address;
	private String guardian_name;
	private String guardian_phone;
	private Long pincode;
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGuardian_name() {
		return guardian_name;
	}
	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}
	public String getGuardian_phone() {
		return guardian_phone;
	}
	public void setGuardian_phone(String guardian_phone) {
		this.guardian_phone = guardian_phone;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	
}
