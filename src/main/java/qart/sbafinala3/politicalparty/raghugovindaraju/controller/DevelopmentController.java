package qart.sbafinala3.politicalparty.raghugovindaraju.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qart.sbafinala3.politicalparty.raghugovindaraju.dto.DevelopmentDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.dto.ResponseDto;
import qart.sbafinala3.politicalparty.raghugovindaraju.exceptions.InvalidDataException;
import qart.sbafinala3.politicalparty.raghugovindaraju.service.DevelopmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/development")
public class DevelopmentController {

	@Autowired
	private DevelopmentService developmentService;

	/* 
	 * US_03 - As a political Leader development work needs to be assigned to me
	 * Request JSON
	 * {     
	 *  "politicalLeaderId": 19,
        "title": "Infrastructure1 ",
        "activity": "Environmental1 dev activity1",
        "budget": 30000.00,
        "state":"Andhra Pradesh",
		"activityMonth":12,
		"activityYear":2025
	  *  }
	  *  Request End Point
	  *  http://localhost:8080/politics/api/v1/development/add-development
	 */
	@PostMapping("/add-development")
	public ResponseEntity<DevelopmentDto> addDevelopments(@Valid @RequestBody DevelopmentDto developmentDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Development Data is not valid");
		}
	
		return ResponseEntity.ok(developmentService.createDevelopment(developmentDto));

	}
	
	/* 
	 * US_05 - As a political Leader i can update development work assigned to me
	 * Request JSON
	 *{  "developmentId":6,
         "politicalLeaderId": 19,
        "title": "Environmental dev activity updated",
        "activity": "Environmental",
        "budget": 40000.00,
        "state":"Telangana State",
		"activityMonth":12,
		"activityYear":2040
    *}
	  *  Request End Point
	  *  http://localhost:8080/politics/api/v1/development/update-development
	 */

	@PutMapping("/update-development")
	public ResponseEntity<DevelopmentDto> updateDevelopments(@Valid @RequestBody DevelopmentDto developmentDto,BindingResult result) {
		
		if (result.hasErrors()) {
			throw new InvalidDataException("Development Data is not valid");
		}
		
		return ResponseEntity.ok(developmentService.updateDevelopment(developmentDto));

	}
	
	/* 
	 * US_04 - As a political Leader i can fetch development work assigned to me
	 * in desc order of assigned work
	 * End-Point exposed to Angular
	 
	  *  Request End Point
	  *  http://localhost:8080/politics/api/v1/development/get-development-by/19
	 */


	@GetMapping("get-development-by/{leaderId}")
	public ResponseEntity<List<ResponseDto>> getAllDevelopmentsByPoliticalLeaderId(@PathVariable Long leaderId) {
		List<ResponseDto> responseDtos = developmentService.getAllDevelopmentsByLeaderIdWithLeaderDetails(leaderId);
		return ResponseEntity.ok(responseDtos);

	}

}
