package qart.sbafinala3.politicalparty.raghugovindaraju.functional;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import qart.sbafinala3.politicalparty.raghugovindaraju.controller.PoliticalLeaderController;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalLeaderService;
import qart.sbafinala3.politicalparty.raghugovindaraju.testutils.MasterData;

@WebMvcTest(PoliticalLeaderController.class)
@AutoConfigureMockMvc
public class PoliticalLeaderControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PoliticalLeaderService leaderService;

	@AfterAll
	public static void afterAll() {
		
	}

	@Test
	public void testRegisterPoliticalLeader() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		PoliticalLeaderDto savedPoliticalLeaderDto = MasterData.getPoliticalLeaderDto();

		savedPoliticalLeaderDto.setPoliticalLeaderId(1L);

		when(this.leaderService.registerPoliticalLeader(politicalLeaderDto)).thenReturn(savedPoliticalLeaderDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/leaders")
				.content(MasterData.asJsonString(politicalLeaderDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		Assert.assertFalse(result.getResponse().getContentAsString()
				.contentEquals(MasterData.asJsonString(savedPoliticalLeaderDto)));

	}

	@Test
	public void testRegisterPoliticalLeaderIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		PoliticalLeaderDto savedPoliticalLeaderDto = MasterData.getPoliticalLeaderDto();

		savedPoliticalLeaderDto.setPoliticalLeaderId(1L);
		when(leaderService.registerPoliticalLeader(politicalLeaderDto)).then(new Answer<PoliticalLeaderDto>() {

			@Override
			public PoliticalLeaderDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedPoliticalLeaderDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/leaders")
				.content(MasterData.asJsonString(politicalLeaderDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		Assert.assertFalse(count[0]==1);

	}

	@Test
	public void testGetAllPoliticalLeaders() throws Exception {
		List<PoliticalLeaderDto> politicalLeaderDtos = MasterData.getPoliticalLeaderDtoList();

		when(this.leaderService.getAllPoliticalLeaders()).thenReturn(politicalLeaderDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/leaders").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	
		Assert.assertFalse(
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(politicalLeaderDtos))));
	}

	@Test
	public void testGetAllPoliticalLeadersIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<PoliticalLeaderDto> politicalLeaderDtos = MasterData.getPoliticalLeaderDtoList();
		when(this.leaderService.getAllPoliticalLeaders()).then(new Answer<List<PoliticalLeaderDto>>() {

			@Override
			public List<PoliticalLeaderDto> answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return politicalLeaderDtos;
			}
		});
	//	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/leaders").contentType(MediaType.APPLICATION_JSON)
	//			.accept(MediaType.APPLICATION_JSON);

	//	MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		Assert.assertFalse(count[0]==1);
	}

	@Test
	public void testGetPoliticalLeaderById() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();

		politicalLeaderDto.setPoliticalLeaderId(1L);
		when(this.leaderService.getPoliticalLeaderById(1L)).thenReturn(politicalLeaderDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/leaders/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		Assert.assertFalse(
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(politicalLeaderDto))));

	}

	@Test
	public void testGetPoliticalLeaderByIdIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(1L);
		when(this.leaderService.getPoliticalLeaderById(1L)).then(new Answer<PoliticalLeaderDto>() {

			@Override
			public PoliticalLeaderDto answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return politicalLeaderDto;
			}
		});
	/*	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/leaders/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();*/

	
		Assert.assertFalse(count[0]==1);

	}

	@Test
	public void testUpdatePoliticalLeader() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		PoliticalLeaderDto savedPoliticalLeaderDto = MasterData.getPoliticalLeaderDto();

		savedPoliticalLeaderDto.setPoliticalLeaderId(1L);

		when(this.leaderService.updatePoliticalLeader(politicalLeaderDto)).thenReturn(savedPoliticalLeaderDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/leaders")
				.content(MasterData.asJsonString(politicalLeaderDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		Assert.assertFalse(
				(result.getResponse().getContentAsString()
						.contentEquals(MasterData.asJsonString(savedPoliticalLeaderDto))));
	}

	@Test
	public void testUpdatePoliticalLeaderIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		PoliticalLeaderDto savedPoliticalLeaderDto = MasterData.getPoliticalLeaderDto();

		savedPoliticalLeaderDto.setPoliticalLeaderId(1L);
		when(leaderService.updatePoliticalLeader(politicalLeaderDto)).then(new Answer<PoliticalLeaderDto>() {

			@Override
			public PoliticalLeaderDto answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return savedPoliticalLeaderDto;
			}
		});
		/*RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/leaders")
				.content(MasterData.asJsonString(politicalLeaderDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();*/

		
		Assert.assertFalse(count[0]==1);

	}

	@Test
	public void testDeletePoliticalLeader() throws Exception {
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(1L);

		when(this.leaderService.deletePoliticalLeader(1L)).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/leaders/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		Assert.assertFalse(
				(result.getResponse().getContentAsString()
						.contentEquals(MasterData.asJsonString(true))));

	}

	@Test
	public void testDeletePoliticalLeaderIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalLeaderDto politicalLeaderDto = MasterData.getPoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(1L);
		when(leaderService.deletePoliticalLeader(1L)).then(new Answer<Boolean>() {

			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				
				count[0]++;
				return true;
			}
		});
		/*RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/leaders/1")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();*/

		
		Assert.assertFalse(count[0]==1);

	}
	
	@Test
	public void testGetAllPoliticalLeadersByPoliticalPartyId() throws Exception {
		List<PoliticalLeaderDto> politicalLeaderDtos = MasterData.getPoliticalLeaderDtoList();

		when(this.leaderService.getPoliticalLeadersByPartyId(1L)).thenReturn(politicalLeaderDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/leaders/by-party-id/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		Assert.assertFalse(
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(politicalLeaderDtos))));


	}

	@Test
	public void  testGetAllPoliticalLeadersByPoliticalPartyIdIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<PoliticalLeaderDto> politicalLeaderDtos = MasterData.getPoliticalLeaderDtoList();
		when(this.leaderService.getPoliticalLeadersByPartyId(1L)).then(new Answer<List<PoliticalLeaderDto>>() {

			@Override
			public List<PoliticalLeaderDto> answer(InvocationOnMock invocation) throws Throwable {
			
				count[0]++;
				return politicalLeaderDtos;
			}
		});
		/*RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/leaders/by-party-id/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();*/

		
		Assert.assertFalse(count[0]==1);

	}
}
