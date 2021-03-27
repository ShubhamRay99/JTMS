package base.repository;

import org.springframework.data.repository.CrudRepository;

import base.model.Enquiry;

public interface EnquiryRepository extends CrudRepository<Enquiry, Long>{

	Enquiry findByNameAndEmail(String name, String email);

	void deleteByNameAndEmail(String name, String email);

}
