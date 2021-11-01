package qart.sbafinala3.politicalparty.raghugovindaraju.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.DevelopmentDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.Development;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.DevelopmentNotFoundException;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.PoliticalLeaderNotFoundException;
import qart.sbafinala3.politicalparty.raghugovindaraju.repository.DevelopmentRepository;
import qart.sbafinala3.politicalparty.raghugovindaraju.repository.PoliticalLeaderRepository;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.DevelopmentService;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalLeaderService;

@Service
public class DevelopmentServiceImpl implements DevelopmentService {

	private static final String NO_POLITICAL_LEADER_ERROR_MESSAGE = "Political Leader Not found for the ID:: ";
	private static final String NO_DEVELPMENT_ERROR_MESSAGE = "Development Record Not found for the ID:: ";

	@Autowired
	private DevelopmentRepository repository;

	@Autowired
	private PoliticalLeaderRepository leaderRepository;

	@Autowired
	private PoliticalLeaderService leaderService;

	@Override
	public DevelopmentDto createDevelopment(DevelopmentDto developmentDto) {

		Optional<PoliticalLeader> politicalLeader = leaderRepository.findById(developmentDto.getPoliticalLeaderId());

		if (politicalLeader.isPresent()) {

			PoliticalLeader leader = politicalLeader.get();// getting existing partyleader

			Development development = new Development(developmentDto.getDevelopmentId(),
					developmentDto.getPoliticalLeaderId(), developmentDto.getTitle(), developmentDto.getActivity(),
					developmentDto.getBudget(), developmentDto.getState(), developmentDto.getActivityMonth(),
					developmentDto.getActivityYear(), leader);

			repository.save(development);
			BeanUtils.copyProperties(repository.findByPoliticalLeaderId(developmentDto.getPoliticalLeaderId()),
					developmentDto);
			return developmentDto;
		} else {
			throw new PoliticalLeaderNotFoundException(
					NO_POLITICAL_LEADER_ERROR_MESSAGE + developmentDto.getPoliticalLeaderId());
		}
	}

	@Override
	public DevelopmentDto updateDevelopment(DevelopmentDto developmentDto) {
		Optional<PoliticalLeader> politicalLeader = leaderRepository.findById(developmentDto.getPoliticalLeaderId());

		if (politicalLeader.isPresent()) {
			
			Optional<Development> development = repository.findServiceWithAssociatedLeader(
					developmentDto.getDevelopmentId(), developmentDto.getPoliticalLeaderId());

			if (development.isPresent()) {
				
				Development developmentEntity=development.get();
				BeanUtils.copyProperties(developmentDto,developmentEntity);
				developmentEntity.setPoliticalleader(politicalLeader.get());
				repository.save(developmentEntity);
				BeanUtils.copyProperties(repository.findServiceWithAssociatedLeader(
						developmentDto.getDevelopmentId(), developmentDto.getPoliticalLeaderId()),developmentDto);
				
				return developmentDto;

			} else {
				throw new DevelopmentNotFoundException(NO_DEVELPMENT_ERROR_MESSAGE + developmentDto.getDevelopmentId());
			}

		} else {
			throw new PoliticalLeaderNotFoundException(
					NO_POLITICAL_LEADER_ERROR_MESSAGE + developmentDto.getPoliticalLeaderId());
		}
	}

	@Override
	public boolean deleteDevelopment(Long developmentId) {
		return false;
	}

	@Override
	public DevelopmentDto getDevelopmentById(Long developmentId) {
		return null;
	}

	@Override
	public List<DevelopmentDto> getAllDevelopments() {
		return null;
	}

	@Override
	public List<DevelopmentDto> getAllDevelopmentsByLeaderId(Long politicalLeaderId) {
		return null;
	}

	@Override
	public List<ResponseDto> getAllDevelopmentsByLeaderIdWithLeaderDetails(Long leaderId) {

		return leaderService.getAllDevelopmentsByLeaderIdWithLeaderDetails(leaderId);
	}

}
