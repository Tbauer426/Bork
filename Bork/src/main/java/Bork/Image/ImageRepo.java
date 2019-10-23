package Bork.Image;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long>{
	
	public Collection<Image> findImageWhereUserIdIsEqualToId(Long id);
	
	public Image findImageById(Long id);
	
}