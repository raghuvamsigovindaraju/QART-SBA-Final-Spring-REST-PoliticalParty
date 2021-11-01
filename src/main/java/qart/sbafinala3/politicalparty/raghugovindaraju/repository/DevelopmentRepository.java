package qart.sbafinala3.politicalparty.raghugovindaraju.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.Development;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;

@Repository
public interface DevelopmentRepository extends JpaRepository<Development, Long> {
   List<Development> findByPoliticalLeaderId(Long politicalLeaderId);

   @Query(value = "SELECT * FROM development d WHERE d.development_id = :developmentId and d.political_leader_id = :politicalLeaderId", 
			  nativeQuery = true)
	Optional<Development> findServiceWithAssociatedLeader(@Param("developmentId") Long developmentId,@Param("politicalLeaderId") Long politicalLeaderId);
}
