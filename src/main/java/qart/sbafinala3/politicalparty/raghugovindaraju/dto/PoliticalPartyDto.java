package qart.sbafinala3.politicalparty.raghugovindaraju.dto;

import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import qart.sbafinala3.politicalparty.raghugovindaraju.entity.PoliticalLeader;

@Validated
public class PoliticalPartyDto {



	private Long politicalPartyId;
	@NotEmpty
	@NotNull
	@Length(min = 5, max = 100,message="partyName should be between 5 and 100 in length")
	private String partyName;
	
	@NotEmpty
	@NotNull
	@Length(min = 5, max = 100,message="partyName should be between 5 and 100 in length")
	private String founderName;
	
	@Digits(integer=4,fraction=0,message="Foundation year should be a number")
	private Long foundationYear;
	
	//@NotNull
	//private Long politicalLeaderId;
	
	private Set<PoliticalLeaderDto> politicalLeaders;
	
	/*
	 * public Long getPoliticalLeaderId() { return politicalLeaderId; }
	 * 
	 * public void setPoliticalLeaderId(Long politicalLeaderId) {
	 * this.politicalLeaderId = politicalLeaderId; }
	 */

	public Long getfoundationYear() {
		return foundationYear;
	}

	public void setfoundationYear(Long foundationYear) {
		this.foundationYear = foundationYear;
	}

	public Long getPoliticalPartyId() {
		return politicalPartyId;
	}

	public void setPoliticalPartyId(Long partyId) {
		this.politicalPartyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}
	
	public Set<PoliticalLeaderDto> getPoliticalLeaders() {
		return politicalLeaders;
	}

	public void setPoliticalLeaders(Set<PoliticalLeaderDto> politicalLeaders) {
		this.politicalLeaders = politicalLeaders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(founderName, politicalPartyId, partyName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PoliticalPartyDto other = (PoliticalPartyDto) obj;
		return Objects.equals(founderName, other.founderName) && Objects.equals(politicalPartyId, other.politicalPartyId)
				&& Objects.equals(partyName, other.partyName);
	}

}
