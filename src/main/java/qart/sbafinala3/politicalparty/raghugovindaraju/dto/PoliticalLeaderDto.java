package qart.sbafinala3.politicalparty.raghugovindaraju.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalParty;

public class PoliticalLeaderDto {

	private Long politicalLeaderId;
	
	@NotNull
	@Digits(integer=6,fraction=0)
	private Long politicalPartyId;
	
	@NotEmpty
	@NotNull
	@Length(min = 5, max = 100,message="leaderName should be between 5 and 100 in length")
	@Column(unique = true)
	private String leaderName;
	
	@NotEmpty
	@NotNull
	@Length(min = 5, max = 100,message="leaderState should be between 5 and 100 in length")
	private String leaderState;
	
	@Valid
	private PoliticalPartyDto politicalparty;
	
	
	public PoliticalLeaderDto() {
		super();
		
	}

	public PoliticalLeaderDto(Long politicalLeaderId, @NotNull @Digits(integer = 6, fraction = 0) Long politicalPartyId,
			@NotEmpty @NotNull @Length(min = 5, max = 100, message = "leaderName should be between 5 and 100 in length") String leaderName,
			@NotEmpty @NotNull @Length(min = 5, max = 100, message = "leaderState should be between 5 and 100 in length") String leaderState,
			@Valid PoliticalPartyDto politicalparty) {
		super();
		this.politicalLeaderId = politicalLeaderId;
		this.politicalPartyId = politicalPartyId;
		this.leaderName = leaderName;
		this.leaderState = leaderState;
		this.politicalparty = politicalparty;
	}


	


	public PoliticalPartyDto getPoliticalparty() {
		return politicalparty;
	}
	
	public void setPoliticalparty(PoliticalPartyDto politicalparty) {
		this.politicalparty = politicalparty;
	}

	public Long getPoliticalLeaderId() {
		return politicalLeaderId;
	}

	public void setPoliticalLeaderId(Long politicalLeaderId) {
		this.politicalLeaderId = politicalLeaderId;
	}

	public Long getPoliticalPartyId() {
		return politicalPartyId;
	}

	public void setPoliticalPartyId(Long partyId) {
		this.politicalPartyId = partyId;
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

	@Override
	public int hashCode() {
		return Objects.hash(politicalLeaderId, leaderName, leaderState, politicalPartyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PoliticalLeaderDto other = (PoliticalLeaderDto) obj;
		return Objects.equals(politicalLeaderId, other.politicalLeaderId)
				&& Objects.equals(leaderName, other.leaderName)
				&& Objects.equals(leaderState, other.leaderState)
				&& Objects.equals(politicalPartyId, other.politicalPartyId);
	}

}
