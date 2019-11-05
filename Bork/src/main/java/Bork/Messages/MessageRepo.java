package Bork.Messages;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Bork.Messages.Message;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long>{
	
	@Query("from Message m where m.longitude <= upLong AND m.longitude >= downLong AND m.latitude <= upLat AND m.latitude >= downLat")
	public Collection<Message> findMessageFromLocation(@Param("id")Long id, @Param("upLong") long upLong,
			@Param("downLong") long downLong, @Param("upLat") long upLat, @Param("downLat") long downLat);
	
	public Message findMessageById(Long id);
	
}