package base.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import base.model.ForgetPasswordLink;

@Repository("forgetPasswordLinkRepository")
public interface ForgetPasswordLinkRepository extends CrudRepository<ForgetPasswordLink, Long>{

	ForgetPasswordLink findByEmail(String adminEmail);

}
