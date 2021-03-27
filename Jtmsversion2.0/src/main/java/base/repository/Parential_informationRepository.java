package base.repository;

import org.springframework.data.repository.CrudRepository;

import base.model.Parential_information;

public interface Parential_informationRepository extends CrudRepository<Parential_information, Long> {

	Parential_information findByStudentId(Long StudentId);
	

}
