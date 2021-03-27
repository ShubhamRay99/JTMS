package base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import base.model.Batch;

public interface BatchRepository extends CrudRepository<Batch, Long>{

	@Query(value = "select * from batch where subject_code = ?", 
	  nativeQuery = true)
	List<Batch> findRequiredBatch(Long subject_code);

	@Query(value = "select * from batch where batch_name = ?", 
      nativeQuery = true)
	Batch findByBatchName(String batchName);

	

}
