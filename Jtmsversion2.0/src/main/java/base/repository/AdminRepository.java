package base.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import base.model.Admin;

@Repository("adminRepo")
public interface AdminRepository extends CrudRepository<Admin, Long>{

	Admin findByNameAndPassword(String name, String password);

	Admin findByEmailAndName(String adminEmail, String adminName);

}
