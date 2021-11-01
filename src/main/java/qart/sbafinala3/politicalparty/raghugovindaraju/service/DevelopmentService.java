package qart.sbafinala3.politicalparty.raghugovindaraju.service;

import java.util.List;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.DevelopmentDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;

public interface DevelopmentService {

	public DevelopmentDto createDevelopment(DevelopmentDto developmentDto);

	public DevelopmentDto updateDevelopment(DevelopmentDto developmentDto);

	public boolean deleteDevelopment(Long developmentId);

	public DevelopmentDto getDevelopmentById(Long developmentId);

	public List<DevelopmentDto> getAllDevelopments();

	public List<DevelopmentDto> getAllDevelopmentsByLeaderId(Long politicalLeaderId);

	public List<ResponseDto> getAllDevelopmentsByLeaderIdWithLeaderDetails(Long leaderId);
	
//	public List<ResponseDto> getAllDevelopmentsByLeaderIdWithLeaderDetails(Long politicalLeaderId);
}
