package qart.sbafinala3.politicalparty.raghugovindaraju.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseDto {
	
    private Long politicalLeaderId;
	
	private String leaderName;
	
	private String leaderState;
	
	private Long politicalPartyId;
	
    private Long developmentId;
   
	private String activity;
	
	private Integer activityMonth;
	
	private Integer activityYear;
	
	private String budget;
	
	private String state;

	private String title;
	

	public ResponseDto(Long politicalLeaderId, String leaderName, String leaderState, Long politicalPartyId,
			Long developmentId, String activity, Integer activityMonth, Integer activityYear, String budget,
			String state, String title) {
		super();
		this.politicalLeaderId = politicalLeaderId;
		this.leaderName = leaderName;
		this.leaderState = leaderState;
		this.politicalPartyId = politicalPartyId;
		this.developmentId = developmentId;
		this.activity = activity;
		this.activityMonth = activityMonth;
		this.activityYear = activityYear;
		this.budget = budget;
		this.state = state;
		this.title = title;
	}

	public Long getPoliticalLeaderId() {
		return politicalLeaderId;
	}

	public void setPoliticalLeaderId(Long politicalLeaderId) {
		this.politicalLeaderId = politicalLeaderId;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getLeaderState() {
		return leaderState;
	}

	public void setLeaderState(String leaderState) {
		this.leaderState = leaderState;
	}

	public Long getPoliticalPartyId() {
		return politicalPartyId;
	}

	public void setPoliticalPartyId(Long politicalPartyId) {
		this.politicalPartyId = politicalPartyId;
	}

	public Long getDevelopmentId() {
		return developmentId;
	}

	public void setDevelopmentId(Long developmentId) {
		this.developmentId = developmentId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Integer getActivityMonth() {
		return activityMonth;
	}

	public void setActivityMonth(Integer activityMonth) {
		this.activityMonth = activityMonth;
	}

	public Integer getActivityYear() {
		return activityYear;
	}

	public void setActivityYear(Integer activityYear) {
		this.activityYear = activityYear;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}










}
