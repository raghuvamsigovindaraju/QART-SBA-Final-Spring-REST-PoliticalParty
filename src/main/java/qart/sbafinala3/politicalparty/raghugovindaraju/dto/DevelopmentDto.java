package qart.sbafinala3.politicalparty.raghugovindaraju.dto;

import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;

public class DevelopmentDto {
	
	private Long developmentId;
	
	@NotNull
	private Long politicalLeaderId;
	
	@NotNull
	@Length(min = 5, max = 100,message="title should be between 5 and 100 in length")
	private String title;
	
	@NotNull
	@Length(min = 5, max = 100,message="activity should be between 5 and 100 in length")
	private String activity;
	
	@Digits(integer=10,fraction=2,message="budget should be a number")
	private String budget;
	
	@NotNull
	@Length(min = 5, max = 100,message="state should be between 5 and 100 in length")
	private String state;
	
	@Min(1)
	@Max(12)
	@Digits(integer=2,fraction=0,message="month should be a number")
	private Integer activityMonth;
	
	@Min(2020)
	@Max(2040)
	@Digits(integer=4,fraction=0,message="year should be a number")
	private Integer activityYear;
	
	private PoliticalLeader politicalleader;
	
	

	public PoliticalLeader getPoliticalleader() {
		return politicalleader;
	}

	public void setPoliticalleader(PoliticalLeader politicalleader) {
		this.politicalleader = politicalleader;
	}

	public DevelopmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DevelopmentDto(Long developmentId, @NotNull Long politicalLeaderId,
			@NotNull @Length(min = 5, max = 100, message = "title should be between 5 and 100 in length") String title,
			@NotNull @Length(min = 5, max = 100, message = "activity should be between 5 and 100 in length") String activity,
			@Digits(integer = 10, fraction = 2, message = "budget should be a number") String budget,
			@NotNull @Length(min = 5, max = 100, message = "state should be between 5 and 100 in length") String state,
			@Min(1) @Max(12) @Digits(integer = 2, fraction = 0, message = "month should be a number") Integer activityMonth,
			@Min(2020) @Max(2040) @Digits(integer = 4, fraction = 0, message = "year should be a number") Integer activityYear,
			PoliticalLeader politicalleader) {
		super();
		this.developmentId = developmentId;
		this.politicalLeaderId = politicalLeaderId;
		this.title = title;
		this.activity = activity;
		this.budget = budget;
		this.state = state;
		this.activityMonth = activityMonth;
		this.activityYear = activityYear;
		this.politicalleader = politicalleader;
	}

	public Long getDevelopmentId() {
		return developmentId;
	}

	public void setDevelopmentId(Long developmentId) {
		this.developmentId = developmentId;
	}

	public Long getPoliticalLeaderId() {
		return politicalLeaderId;
	}

	public void setPoliticalLeaderId(Long candidateId) {
		this.politicalLeaderId = candidateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
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

	@Override
	public int hashCode() {
		return Objects.hash(activity, activityMonth, activityYear, budget, politicalLeaderId, developmentId, state, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DevelopmentDto other = (DevelopmentDto) obj;
		return Objects.equals(activity, other.activity) && Objects.equals(activityMonth, other.activityMonth)
				&& Objects.equals(activityYear, other.activityYear) && Objects.equals(budget, other.budget)
				&& Objects.equals(politicalLeaderId, other.politicalLeaderId) && Objects.equals(developmentId, other.developmentId)
				&& Objects.equals(state, other.state) && Objects.equals(title, other.title);
	}

}
