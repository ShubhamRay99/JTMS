package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Enquiry {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="enquiry_id")
		private Long id;
		
		@Column(name="student_name")
		private String name;
		@Column(name="email")
		private String email;
		@Column(name="mobile")
		private Long phone;
		@Column(name="subject")
		private String subject;
		@Column(name="advertising_agent")
		private String advertising_agent;
		@Column(name="college")
		private String college;
		@Column(name="branch")
		private String branch;
		
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Long getMobile() {
			return phone;
		}
		public void setMobile(Long mobile) {
			this.phone = mobile;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getAdvertising_agent() {
			return advertising_agent;
		}
		public void setAdvertising_agent(String advertising_agent) {
			this.advertising_agent = advertising_agent;
		}
		public String getCollege() {
			return college;
		}
		public void setCollege(String college) {
			this.college = college;
		}
}
