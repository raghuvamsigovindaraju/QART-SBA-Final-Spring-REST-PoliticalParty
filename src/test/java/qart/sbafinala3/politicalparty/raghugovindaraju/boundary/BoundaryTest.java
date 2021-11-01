package qart.sbafinala3.politicalparty.raghugovindaraju.boundary;


import java.util.Set;
import java.util.stream.IntStream;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.DevelopmentDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalPartyDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.testutils.*;



@ExtendWith(SpringExtension.class)
public class BoundaryTest {
	private static Validator validator;

	// ----------------------------------------------------------------------------------------------
	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		// testReport();
	}

	@Test
	public void testDevelopmentPoliticalLeaderIdNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setPoliticalLeaderId(null);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentTitleNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setTitle("");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentTitleMinFive() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setTitle("abcd");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentTitleMaxHundred() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		String title = "";

		IntStream.range(1, 102).forEach(val -> title.concat("X"));

		developmentDto.setTitle(title);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentActivityNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivity(null);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentActivityMinFive() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivity("abcd");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentActivityMaxHundred() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		String activity = "";
		IntStream.range(1, 102).forEach(val -> activity.concat("X"));

		developmentDto.setActivity(activity);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentBudgetDecimalFraction() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setBudget("20.223");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentActivityYearMin2020() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivityYear(2019);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentActivityYearMax2040() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();

		developmentDto.setActivityYear(2045);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentActivityMonthMin1() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setActivityMonth(-1);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentActivityMonthMax12() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();

		developmentDto.setActivityMonth(13);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentStateNotNull() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setState(null);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentStateMinThree() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		developmentDto.setState("ab");
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testDevelopmentStateMaxFifty() throws Exception {
		DevelopmentDto developmentDto = MasterData.getDevelopmentDto();
		String state = "";
		IntStream.range(1, 52).forEach(val -> state.concat("X"));

		developmentDto.setState(state);
		Set<ConstraintViolation<DevelopmentDto>> violations = validator.validate(developmentDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testPoliticalLeaderPartyIDNotNull() {
		PoliticalLeaderDto partyLeaderDto = MasterData.getPoliticalLeaderDto();
		partyLeaderDto.setPoliticalPartyId(null);
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(partyLeaderDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testPoliticalLeaderPartyIDIsNumber() {
		PoliticalLeaderDto partyLeaderDto = MasterData.getPoliticalLeaderDto();
		partyLeaderDto.setPoliticalPartyId(null);
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(partyLeaderDto);
		Assert.assertFalse(violations.isEmpty());
		try {
			partyLeaderDto.getPoliticalLeaderId();
			Assert.assertTrue(true);
		} catch (NumberFormatException nfe) {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void testPoliticalLeaderNameNotNull() {
		PoliticalLeaderDto partyLeaderDto = MasterData.getPoliticalLeaderDto();
		partyLeaderDto.setLeaderName(null);
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(partyLeaderDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testPoliticalLeaderNameMinFive() throws Exception {
		PoliticalLeaderDto partyLeaderDto = MasterData.getPoliticalLeaderDto();
		partyLeaderDto.setLeaderName("abcds");
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(partyLeaderDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void tesPoliticalLeaderNameMaxHundred() throws Exception {
		PoliticalLeaderDto partyLeaderDto = MasterData.getPoliticalLeaderDto();
		String leaderName = "";
		partyLeaderDto.setLeaderName("");
		IntStream.range(1, 102).forEach(val -> leaderName.concat("X"));

		partyLeaderDto.setLeaderName(leaderName);
		Set<ConstraintViolation<PoliticalLeaderDto>> violations = validator.validate(partyLeaderDto);
		Assert.assertFalse(violations.isEmpty());
	}
	@Test
	public void testPoliticalLeaderPartyNameMinFive() throws Exception {
		PoliticalPartyDto partyDto = MasterData.getPartyDto();
		partyDto.setPartyName("abcd");
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(partyDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void tesPoliticalLeaderPartyNameMaxHundred() throws Exception {
		PoliticalPartyDto partyDto = MasterData.getPartyDto();
		String partyName = "";
	
		IntStream.range(1, 102).forEach(val -> partyName.concat("X"));

		partyDto.setPartyName(partyName);
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(partyDto);
		Assert.assertFalse(violations.isEmpty());
	}
	
	@Test
	public void testPoliticalPartyFounderNameNotNull() throws Exception {
		PoliticalPartyDto partyDto = MasterData.getPartyDto();
		partyDto.setFounderName(null);
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(partyDto);
		Assert.assertFalse(violations.isEmpty());
	}
	@Test
	public void testPoliticalPartyFounderNameMinFive() throws Exception {
		PoliticalPartyDto partyDto = MasterData.getPartyDto();
		partyDto.setFounderName("abcd");
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(partyDto);
		Assert.assertFalse(violations.isEmpty());
	}

	@Test
	public void testPoliticalPartyFounderNameMaxHundred() throws Exception {
		PoliticalPartyDto partyDto = MasterData.getPartyDto();
		String founderName = "";

		IntStream.range(1, 102).forEach(val -> founderName.concat("X"));

		partyDto.setFounderName(founderName);
		Set<ConstraintViolation<PoliticalPartyDto>> violations = validator.validate(partyDto);
		Assert.assertFalse(violations.isEmpty());
	}
	

}
