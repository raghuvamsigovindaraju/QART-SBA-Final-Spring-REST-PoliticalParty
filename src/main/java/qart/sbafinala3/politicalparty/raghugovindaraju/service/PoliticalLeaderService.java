package qart.sbafinala3.politicalparty.raghugovindaraju.service;

import java.util.List;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;

public interface PoliticalLeaderService {

	public PoliticalLeaderDto registerPoliticalLeader(PoliticalLeaderDto leaderDto);

	public PoliticalLeaderDto updatePoliticalLeader(PoliticalLeaderDto leaderDto);

	public boolean deletePoliticalLeader(Long politicalLeaderId);

	public PoliticalLeaderDto getPoliticalLeaderById(Long politicalLeaderId);

	public List<PoliticalLeaderDto> getAllPoliticalLeaders();

	public List<PoliticalLeaderDto> getPoliticalLeadersByPartyId(Long politicalLeaderId);
	public List<ResponseDto> getAllDevelopmentsByLeaderIdWithLeaderDetails(Long politicalLeaderId);

	

}
