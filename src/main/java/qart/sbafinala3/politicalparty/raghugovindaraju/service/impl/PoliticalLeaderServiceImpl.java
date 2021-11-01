package qart.sbafinala3.politicalparty.raghugovindaraju.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalParty;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.PoliticalLeaderNotFoundException;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.PoliticalPartyNotFoundException;
import qart.sbafinala3.politicalparty.raghugovindaraju.repository.PoliticalLeaderRepository;
import qart.sbafinala3.politicalparty.raghugovindaraju.repository.PoliticalPartyRepository;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalLeaderService;

@Service
public class PoliticalLeaderServiceImpl implements PoliticalLeaderService {

	private static final String NO_POLITICAL_PARTY_ERROR_MESSAGE = "Political Party Not found for the ID:: ";
	private static final String NO_POLITICAL_LEADER_ERROR_MESSAGE = "Political Leader Not found for the ID:: ";

	@Autowired
	private PoliticalLeaderRepository repository;
	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;

	@Override
	public PoliticalLeaderDto registerPoliticalLeader(PoliticalLeaderDto leaderDto) {


		Optional<PoliticalParty> politicalParty = politicalPartyRepository.findById(leaderDto.getPoliticalPartyId());

		if (politicalParty.isPresent()) {

			PoliticalParty party = politicalParty.get();// getting existing party

			PoliticalLeader politicalLeader1 = new PoliticalLeader(leaderDto.getPoliticalLeaderId(), leaderDto.getPoliticalPartyId(), leaderDto.getLeaderName(), leaderDto.getLeaderState(),
					party);
		
			repository.save(politicalLeader1);
			BeanUtils.copyProperties(repository.getById(politicalLeader1.getPoliticalLeaderId()), leaderDto);
			return leaderDto;
		} else {
			throw new PoliticalPartyNotFoundException(
					NO_POLITICAL_PARTY_ERROR_MESSAGE + leaderDto.getPoliticalPartyId());
		}

	}

	@Override
	public PoliticalLeaderDto updatePoliticalLeader(PoliticalLeaderDto leaderDto) {
		PoliticalLeader politicalLeader = new PoliticalLeader();
		BeanUtils.copyProperties(leaderDto, politicalLeader);
		repository.save(politicalLeader);
		return leaderDto;
	}

	@Override
	public boolean deletePoliticalLeader(Long politicalLeaderId) {

		Optional<PoliticalLeader> politicalLeader = repository.findById(politicalLeaderId);
	

		if (politicalLeader.isPresent()) {
			Optional<PoliticalParty> politicalParty = politicalPartyRepository
					.findById(politicalLeader.get().getPoliticalPartyId());
			if (politicalParty.isPresent()) {

				PoliticalLeaderDto politicalLeaderById = getPoliticalLeaderById(politicalLeaderId);
				PoliticalLeader leader = new PoliticalLeader();
				BeanUtils.copyProperties(politicalLeaderById, leader);
				repository.delete(leader);
				return true;

			} else {
				throw new PoliticalPartyNotFoundException(NO_POLITICAL_PARTY_ERROR_MESSAGE + politicalLeaderId);
			}

		} else {
			throw new PoliticalLeaderNotFoundException(NO_POLITICAL_LEADER_ERROR_MESSAGE + politicalLeaderId);
		}

	}

	@Override
	public PoliticalLeaderDto getPoliticalLeaderById(Long politicalLeaderId) {
		Optional<PoliticalLeader> politicalLeader = repository.findById(politicalLeaderId);
		if (politicalLeader.isPresent()) {
			PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto();
			BeanUtils.copyProperties(politicalLeader.get(), politicalLeaderDto);
			return politicalLeaderDto;
		} else {
			throw new PoliticalLeaderNotFoundException("Political Leader with id " + politicalLeaderId + " not found");
		}

	}

	@Override
	public List<PoliticalLeaderDto> getAllPoliticalLeaders() {
		List<PoliticalLeader> politicalLeaders = repository.findAll();
		
		List<PoliticalLeaderDto> politicalLeaderDtos = new ArrayList<>();
		for (PoliticalLeader leader : politicalLeaders) {
			PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto();
			BeanUtils.copyProperties(leader, politicalLeaderDto);
			politicalLeaderDtos.add(politicalLeaderDto);

		}
		return politicalLeaderDtos;
	}

	@Override
	public List<PoliticalLeaderDto> getPoliticalLeadersByPartyId(Long politicalLeaderId) {
		List<PoliticalLeader> politicalLeaders = repository.findByPoliticalPartyId(politicalLeaderId);
		List<PoliticalLeaderDto> politicalLeaderDtos = new ArrayList<>();
		for (PoliticalLeader leader : politicalLeaders) {
			PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto();
			BeanUtils.copyProperties(leader, politicalLeaderDto);
			politicalLeaderDtos.add(politicalLeaderDto);
		}
		return politicalLeaderDtos;

	}

	@Override
	public List<ResponseDto> getAllDevelopmentsByLeaderIdWithLeaderDetails(Long politicalLeaderId) {

		return repository.findAllDevelopmentActivitesByLeader(politicalLeaderId);
	}



}
