package Bork.Dog;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends CrudRepository<Dog, Long>{
	
	@Query("from Dog d where d.ownerId = id")
	public Collection<Dog> findDogWhereOwnerIdIsEqualToId(@Param("id") Long id);
	
	public Dog findDogById(Long id);
	 
	@Query("from Dog d where d.age <= ageUper And d.age >= ageLower And d.sex = sex And d.breed = breed And d.latitude <= latMax"/* And d.latitude >= latMin And d.longitude >= longMax And d.longitude <= longMin"*/)
	public Collection<Dog> findByRequirements(@Param("ageUper") int ageUper, @Param("ageLower") int ageLower, 
			@Param("sex") char sex, @Param("breed") String breed, @Param("latMax") long latMax, 
			@Param("latMin") long latMin, @Param("longMax") long longMax, @Param("longMin") long longMin);
}