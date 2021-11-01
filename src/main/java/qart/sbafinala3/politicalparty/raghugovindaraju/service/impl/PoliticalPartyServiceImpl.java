package qart.sbafinala3.politicalparty.raghugovindaraju.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalPartyDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalParty;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.PoliticalLeaderNotFoundException;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.PoliticalPartyNotFoundException;
import qart.sbafinala3.politicalparty.raghugovindaraju.repository.PoliticalLeaderRepository;
import qart.sbafinala3.politicalparty.raghugovindaraju.repository.PoliticalPartyRepository;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalPartyService;

@Service
public class PoliticalPartyServiceImpl implements PoliticalPartyService {

	private static final String NO_POLITICAL_PARTY_ERROR_MESSAGE = "Political Party Not found for the ID:: ";
	private static final String NO_POLITICAL_LEADER_ERROR_MESSAGE = "Political Leader Not found or Associated for the partyid and leaderid:: ";

	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;
	
	@Autowired
	private PoliticalLeaderRepository politicalLeaderRepository;

	@Override
	public PoliticalPartyDto registerParty(PoliticalPartyDto politicalPartyDto) {
		PoliticalParty politicalParty = new PoliticalParty();
		BeanUtils.copyProperties(politicalPartyDto, politicalParty);
		politicalPartyRepository.save(politicalParty);
		return politicalPartyDto;
	}

	@Override
	public PoliticalPartyDto updateParty(PoliticalPartyDto politicalPartyDto) {
		PoliticalParty politicalParty = new PoliticalParty();
		BeanUtils.copyProperties(politicalPartyDto, politicalParty);
		politicalPartyRepository.save(politicalParty);
		return politicalPartyDto;
	}

	@Override
	public boolean deleteParty(Long partyId) {
		PoliticalPartyDto politicalPartyDto = getPartyById(partyId);
		PoliticalParty politicalParty = new PoliticalParty();
		BeanUtils.copyProperties(politicalPartyDto, politicalParty);
		politicalPartyRepository.delete(politicalParty);
		return false;
	}

	@Override
	public Boolean deletePoliticalLeaderfromParty(Long partyId, Long politicalLeaderId) {

		Optional<PoliticalParty> politicalParty = politicalPartyRepository.findById(partyId);

		if (politicalParty.isPresent()) {
			Optional<PoliticalLeader> politicalLeader = politicalLeaderRepository.findLeaderWithAssociatedParty(politicalLeaderId, partyId);
			if (politicalLeader.isPresent()) {

				politicalLeaderRepository.delete(politicalLeader.get());
				return true;

			} else {
				throw new PoliticalLeaderNotFoundException(NO_POLITICAL_LEADER_ERROR_MESSAGE + partyId+"::"+politicalLeaderId);
			}

		} else {
			throw new PoliticalPartyNotFoundException(NO_POLITICAL_PARTY_ERROR_MESSAGE + partyId);
		}

	}

	@Override
	public PoliticalPartyDto getPartyById(Long partyId) {
		Optional<PoliticalParty> politicalParty = politicalPartyRepository.findById(partyId);
		if (politicalParty.isPresent()) {
			PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
			BeanUtils.copyProperties(politicalParty.get(), politicalPartyDto);
			return politicalPartyDto;
		} else {
			throw new PoliticalPartyNotFoundException("Party with Id " + partyId + " not found");
		}
	}

	@Override
	public List<PoliticalPartyDto> getAllParties() {
		List<PoliticalParty> politicalParties = politicalPartyRepository.findAll();
		List<PoliticalPartyDto> politicalPartyDtos = new ArrayList<>();
		for (PoliticalParty politicalParty : politicalParties) {
			PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
			BeanUtils.copyProperties(politicalParty, politicalPartyDto);
			politicalPartyDtos.add(politicalPartyDto);
		}
		return politicalPartyDtos;
	}

}
