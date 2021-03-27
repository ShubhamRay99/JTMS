package base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import base.model.JtianBookIssue;

public interface JtianBookIssueRepository extends CrudRepository<JtianBookIssue, Long>{

	@Modifying
	@Query(value = "select * from Jtian_Book_Issue where student_id = ?", 
	  nativeQuery = true)
	List<JtianBookIssue> findByStudentId(Long personal_id);
	
}
