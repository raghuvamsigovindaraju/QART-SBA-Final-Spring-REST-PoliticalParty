package qart.sbafinala3.politicalparty.raghugovindaraju.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalParty;

@Repository
public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {
}
