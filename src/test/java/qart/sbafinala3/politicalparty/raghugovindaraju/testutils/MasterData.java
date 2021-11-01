package qart.sbafinala3.politicalparty.raghugovindaraju.testutils;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.databind.ObjectMapper;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.DevelopmentDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalPartyDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;
import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalParty;

public class MasterData {

	public static PoliticalPartyDto getPartyDto() {
		PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
		politicalPartyDto.setPoliticalPartyId(1L);
		politicalPartyDto.setPartyName("Party abcded");
		politicalPartyDto.setFounderName("abdfdfd");
		return politicalPartyDto;
	}

	public static List<PoliticalPartyDto> getPartyDtoList() {
		List<PoliticalPartyDto> politicalPartyDtos = new ArrayList<PoliticalPartyDto>();
		PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
		politicalPartyDto.setPoliticalPartyId(1L);
		politicalPartyDto.setPartyName("Party abcded");
		politicalPartyDto.setFounderName("David");
		politicalPartyDtos.add(politicalPartyDto);
		politicalPartyDto = new PoliticalPartyDto();
		politicalPartyDto.setPoliticalPartyId(2L);
		politicalPartyDto.setPartyName("State Party");
		politicalPartyDto.setFounderName("xfdfd");
		politicalPartyDtos.add(politicalPartyDto);
		return politicalPartyDtos;
	}

	public static PoliticalLeaderDto getPoliticalLeaderDto() {
		PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto(Long.valueOf(1),Long.valueOf(1),"ABCDEFGH","ABCDdef",new PoliticalPartyDto());
		
		return politicalLeaderDto;
	
	}

	public static List<PoliticalLeaderDto> getPoliticalLeaderDtoList() {
		List<PoliticalLeaderDto> politicalLeaderDtos = new ArrayList<>();
		PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(1L);
		politicalLeaderDto.setPoliticalPartyId(1L);
		politicalLeaderDto.setLeaderName("Raghu");
		politicalLeaderDto.setLeaderState("Karnataka");
		politicalLeaderDtos.add(politicalLeaderDto);
		politicalLeaderDto = new PoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(2L);
		politicalLeaderDto.setPoliticalPartyId(2L);
		politicalLeaderDto.setLeaderName("Rakesh");
		politicalLeaderDto.setLeaderState("Bihar");
		politicalLeaderDtos.add(politicalLeaderDto);
		return politicalLeaderDtos;
	}

	public static DevelopmentDto getDevelopmentDto() {
		DevelopmentDto developmentDto = new DevelopmentDto(Long.valueOf(1),Long.valueOf(1),"Environmental","Forest Dev",
				"25000","telangana",Integer.valueOf(10),Integer.valueOf(2025),new PoliticalLeader());
		return developmentDto;

	}

	public static List<DevelopmentDto> getDevelopmentDtoList() {
		List<DevelopmentDto> developmentDtos = new ArrayList<>();
		DevelopmentDto developmentDto = new DevelopmentDto();
		developmentDto.setDevelopmentId(1L);
		developmentDto.setPoliticalLeaderId(1L);
		developmentDto.setTitle("Environment");
		developmentDto.setBudget("250000");
		developmentDto.setActivity("Making Reads");
		developmentDto.setActivityMonth(5);
		developmentDto.setActivityYear(2022);
		developmentDto.setState("karnataka");
		developmentDtos.add(developmentDto);
		developmentDto = new DevelopmentDto();
		developmentDto.setDevelopmentId(2L);
		developmentDto.setPoliticalLeaderId(2L);
		developmentDto.setTitle("Environment dev");
		developmentDto.setBudget("250000");
		developmentDto.setActivity("Environment dev Camp");
		developmentDto.setActivityMonth(9);
		developmentDto.setActivityYear(2022);
		developmentDto.setState("Telangana");
		developmentDtos.add(developmentDto);
		return developmentDtos;

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
