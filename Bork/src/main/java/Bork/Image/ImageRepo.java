package Bork.Image;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long>{
	
	@Query("from Image i where i.userId = id")
	public Collection<Image> findImageWhereUserIdIsEqualToId(@Param("id")Long id);
	
	public Image findImageById(Long id);
	
}