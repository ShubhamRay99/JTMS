package base.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_course_info")
public class StudentCourseInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	private Long studentid;
	private String batchName;
	private Long subjectCode;
	private Integer payed;
	private Integer due;
	private Boolean certificate;
	
	
	public Long getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(Long subjectCode) {
		this.subjectCode = subjectCode;
	}
	public Integer getPayed() {
		return payed;
	}
	public void setPayed(Integer payed) {
		this.payed = payed;
	}
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public Integer getDue() {
		return due;
	}
	public void setDue(Integer due) {
		this.due = due;
	}
	
	public Boolean getCertificate() {
		return certificate;
	}
	public void setCertificate(Boolean certificate) {
		this.certificate = certificate;
	}
	
}
