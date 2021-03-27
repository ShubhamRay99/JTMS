package base.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import base.model.StudentCourseInfo;

public interface StudentCourseInfoRepository extends CrudRepository<StudentCourseInfo, Long>{

	@Query(value = "select * from Student_course_info s where s.studentid = ?1 and s.batch_name = ?2", 
	  nativeQuery = true)
	StudentCourseInfo findRequiredCourse(Long id, String batchName);

	@Query(value = "select * from Student_course_info where studentid = ? ", 
			nativeQuery = true)
	List<StudentCourseInfo> findListOfRequiredCourses(Long studentid);
	
//	@Query("delete * from Student_course_info where cid = ?1 and studentid = ?2 ")
//	void deleteByCidAndStudentid(Long courseId, Long studentId);
	
	
	@Modifying 
    @Transactional
	@Query(value = "DELETE FROM Student_course_info WHERE cid = :id and studentid = :sid ",nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    int deleteByCidAndStudentIdNative(Long id, Long sid); 

}
