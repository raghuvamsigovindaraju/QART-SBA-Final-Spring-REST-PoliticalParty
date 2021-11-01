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

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.PoliticalPartyDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.InvalidDataException;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalLeaderService;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.PoliticalPartyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/party")
public class PoliticalPartyController {

	@Autowired
	private PoliticalPartyService politicalPartyService;
	
	@Autowired
	private PoliticalLeaderService politicalLeaderService;
   
	/* 
	 * Register a party
	 * Request JSON
	 * 	  {
    
        "partyName": "xyz party ",
        "founderName": "dfdfd CM",
        "foundationYear": 2000
    *  }
     
	  *  Request End Point
	  *  http://localhost:8080/politician-ratings/parties/register-party
	 */
	@PostMapping("/register-party")
	public ResponseEntity<?> createParty(@Valid @RequestBody PoliticalPartyDto politicalPartyDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Party Data is not Valid");
		}
		politicalPartyService.registerParty(politicalPartyDto);
		return ResponseEntity.ok(politicalPartyDto);

	}

	@PutMapping
	public ResponseEntity<?> updateParty(PoliticalPartyDto politicalPartyDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Party Data is not Valid");
		}
		politicalPartyService.updateParty(politicalPartyDto);
		return ResponseEntity.ok(politicalPartyDto);

	}
	
	/* 
	 * US02- Delete a leader from  a party
	
	  *  Request End Point
	  *  http://localhost:8080/politician-ratings/parties/delete/1/19
	 */
	
	@DeleteMapping("/delete/{partyId}/{politicalLeaderId}")
	public ResponseEntity<Boolean> deletePoliticalLeaderfromParty(@PathVariable Long partyId,@PathVariable Long politicalLeaderId) {

		politicalPartyService.deletePoliticalLeaderfromParty(partyId,politicalLeaderId);
		return ResponseEntity.ok(true);

	}

	
	/* 
	 * Fetch all leaders
	 * End-Point exposed to Angualar
	
	  *  Request End Point
	  *  http://localhost:8080/politics/api/v1/leader/all
	 */

	@GetMapping("/all")
	public ResponseEntity<List<PoliticalPartyDto>> getAllParties() {
		List<PoliticalPartyDto> politicalPartyDtos = politicalPartyService.getAllParties();
		return ResponseEntity.ok(politicalPartyDtos);
	}



}
