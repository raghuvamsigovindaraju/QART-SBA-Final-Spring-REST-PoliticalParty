package qart.sbafinala3.politicalparty.raghugovindaraju.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;

@Repository
public interface PoliticalLeaderRepository extends JpaRepository<PoliticalLeader, Long> {
	List<PoliticalLeader> findByPoliticalPartyId(Long politicalPartyId);
	
	@Query(value = "SELECT * FROM politicalleader p WHERE p.political_leader_id = :politicalLeaderId and p.political_party_id = :politicalPartyId", 
			  nativeQuery = true)
	Optional<PoliticalLeader> findLeaderWithAssociatedParty(@Param("politicalLeaderId") Long politicalLeaderId,@Param("politicalPartyId") Long politicalPartyId);
	
	   @Query("SELECT new qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto(p.politicalLeaderId,p.leaderName,p.leaderState,"
	   		+ "p.politicalPartyId,d.developmentId,d.activity,d.activityMonth,"
	   		+ "d.activityYear,d.budget,d.state,d.title) FROM PoliticalLeader p left outer join p.developments d where d.politicalLeaderId =:politicalLeaderId order by d.activityYear desc")
	 List<ResponseDto> findAllDevelopmentActivitesByLeader(Long politicalLeaderId);
}
