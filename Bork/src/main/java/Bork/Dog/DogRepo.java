package Bork.Dog;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends CrudRepository<Dog, Long>{
	
	public Collection<Dog> findDogWhereOwnerIdIsEqualToId(Long id);
	
	public Dog findDogById(Long id);
	
	@Query("from Dog d where d.age <= ageUper And d.age >= ageLower And d.sex = sex And d.breed = breed And "
			+ "d.latitude <= latMax And d.latitude >= latMin And d.longitude <= longMin And d.longitude >= longMax")
	public Collection<Dog> findByRequirements(@Param("ageUper") int ageUper, @Param("ageLower") int ageLower, 
			@Param("sex") char sex, @Param("breed") String breed, @Param("latMax") long latMax, 
			@Param("latMin") Long latMin, @Param("longMax") Long longMax, @Param("longMin") Long longMin);
}