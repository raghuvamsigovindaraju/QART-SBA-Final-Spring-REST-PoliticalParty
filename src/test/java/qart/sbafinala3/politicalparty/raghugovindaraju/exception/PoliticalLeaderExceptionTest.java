package qart.sbafinala3.politicalparty.raghugovindaraju.exception;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import qart.sbafinala3.politicalparty.raghugovindaraju.controller.PoliticalLeaderController;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.PoliticalLeaderNotFoundException;
import qart.sbafinala3.politicalparty.raghugovindaraju.model.exception.ExceptionResponse;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalLeaderService;
import qart.sbafinala3.politicalparty.raghugovindaraju.testutils.MasterData;

@WebMvcTest(PoliticalLeaderController.class)
@AutoConfigureMockMvc
public class PoliticalLeaderExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PoliticalLeaderService leaderService;

	@AfterAll
	public static void afterAll() {
	
	}

	@Test
	public void testRegisterPoliticalLeaderInvalidDataException() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		PoliticalLeaderDto savedPoliticalLeaderDto = MasterData.getPoliticalLeaderDto();
		savedPoliticalLeaderDto.setPoliticalPartyId(1L);

		politicalLeaderDto.setLeaderName("xyz");

		when(this.leaderService.registerPoliticalLeader(politicalLeaderDto)).thenReturn(savedPoliticalLeaderDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/leaders/register-leader")
				.content(MasterData.asJsonString(politicalLeaderDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
    Assert.assertEquals(404,result.getResponse().getStatus());
	

	}

	@Test
	public void testUpdatePoliticalLeaderInvalidDataException() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		PoliticalLeaderDto savedPoliticalLeaderDto = MasterData.getPoliticalLeaderDto();
		savedPoliticalLeaderDto.setPoliticalPartyId(1L);

		politicalLeaderDto.setLeaderName("xyz");

		when(this.leaderService.registerPoliticalLeader(politicalLeaderDto)).thenReturn(savedPoliticalLeaderDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/leaders")
				.content(MasterData.asJsonString(politicalLeaderDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		  Assert.assertEquals(404,result.getResponse().getStatus());

	}

	@Test
	public void testDeletePoliticalLeaderNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("Political Leader with Id - 2 not Found!",
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());

		when(this.leaderService.deletePoliticalLeader(2L))
				.thenThrow(new PoliticalLeaderNotFoundException("Political Leader with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/leaders/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  Assert.assertEquals(404,result.getResponse().getStatus());

	}

	@Test
	public void testGetPoliticalLeaderByIdPoliticalLeaderNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("Political Leader with Id - 2 not Found!",
				System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());

		when(this.leaderService.getPoliticalLeaderById(2L))
				.thenThrow(new PoliticalLeaderNotFoundException("Political Leader with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/leaders/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  Assert.assertEquals(404,result.getResponse().getStatus());

	}


}
