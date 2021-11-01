package qart.sbafinala3.politicalparty.raghugovindaraju.service;

import java.util.List;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalPartyDto;

public interface PoliticalPartyService {

	public PoliticalPartyDto registerParty(PoliticalPartyDto politicalPartyDto);

	public PoliticalPartyDto updateParty(PoliticalPartyDto politicalPartyDto);

	public boolean deleteParty(Long partyId);

	public PoliticalPartyDto getPartyById(Long partyId);

	public List<PoliticalPartyDto> getAllParties();
	
	public Boolean deletePoliticalLeaderfromParty(Long partyId, Long politicalLeaderId);


}
