package qart.sbafinala3.politicalparty.raghugovindaraju.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalLeaderDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.InvalidDataException;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalLeaderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")


@RequestMapping("/leader")
public class PoliticalLeaderController {

	@Autowired
	private PoliticalLeaderService politicalLeaderService;
	
	/* 
	 * US_01 - As a political Leader i can register myself to a party
	 * Request JSON
	 * 	 {
	   "politicalPartyId":1,
	   "leaderName":"leader name",
	   "leaderState":"some state20",
	    "politicalparty":
		 {
		  "partyName": "TRS Party ",
        "founderName": "KCR CM",
        "foundationYear": 2000,
        "politicalLeaderId":1
		 }
      * }
	  *  Request End Point
	  *  http://localhost:8080/politics/api/v1/leader/register-leader
	 */

	@PostMapping("/register-leader")
	public ResponseEntity<PoliticalLeaderDto> addPoliticalLeader(@Valid @RequestBody PoliticalLeaderDto politicalLeaderDto,BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Political Leader Data is not valid");
		}
		
		return ResponseEntity.ok(politicalLeaderService.registerPoliticalLeader(politicalLeaderDto));

	}
		
	/* 
	 * Fetch all leaders	
	  *  Request End Point
	  *  http://localhost:8080/politics/api/v1/leader/all
	 */

	@GetMapping("/all")
	public ResponseEntity<List<PoliticalLeaderDto>> getAllPoliticalLeader() {
		List<PoliticalLeaderDto> allPoliticalLeaders = politicalLeaderService.getAllPoliticalLeaders();
		return ResponseEntity.ok(allPoliticalLeaders);

	}

	@GetMapping("get-development-by/{leaderId}")
	public ResponseEntity<List<ResponseDto>> getAllDevelopmentsByPoliticalLeaderId(@PathVariable Long leaderId) {
		List<ResponseDto> responseDtos = politicalLeaderService.getAllDevelopmentsByLeaderIdWithLeaderDetails(leaderId);
		return ResponseEntity.ok(responseDtos);

	}

}
