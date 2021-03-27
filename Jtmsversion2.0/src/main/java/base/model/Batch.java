package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Batch {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long batch_id;
	@Column
	private String batch_starting_date;
	@Column
	private String arrival_timing;
	@Column
	private String departure_timing;
	@Column(name = "batch_name")
	private String batchName;
	private Long  subject_code;
	
	public Long getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(Long subject_code) {
		this.subject_code = subject_code;
	}
	public Long getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(Long batch_id) {
		this.batch_id = batch_id;
	}
	public String getBatch_starting_date() {
		return batch_starting_date;
	}
	public void setBatch_starting_date(String batch_starting_date) {
		this.batch_starting_date = batch_starting_date;
	}
	public String getArrival_timing() {
		return arrival_timing;
	}
	public void setArrival_timing(String arrival_timing) {
		this.arrival_timing = arrival_timing;
	}
	public String getDeparture_timing() {
		return departure_timing;
	}
	public void setDeparture_timing(String departure_timing) {
		this.departure_timing = departure_timing;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
 
}
