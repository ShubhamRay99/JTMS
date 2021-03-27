package base.repository;

import org.springframework.data.repository.CrudRepository;

import base.model.Student_personal_info;

public interface Student_personal_infoRepository extends CrudRepository<Student_personal_info, Long>{

	Student_personal_info findByNameAndEmail(String name, String email);

	
}
