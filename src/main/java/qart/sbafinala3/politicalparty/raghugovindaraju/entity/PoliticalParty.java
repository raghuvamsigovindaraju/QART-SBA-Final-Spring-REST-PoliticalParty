package qart.sbafinala3.politicalparty.raghugovindaraju.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;


@Entity
@Table(name = "politicalparty")
public class PoliticalParty implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long politicalPartyId;
	

	private String partyName;
	
	private String founderName;
	
	private Long foundationYear;
	

	//private Long politicalLeaderId;
	//@OneToMany(targetEntity=PoliticalLeader.class,cascade=CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
	//@JoinColumn(name = "politicalPartyId",referencedColumnName="politicalPartyId")
	//@JoinColumn(name = "politicalPartyId")
	
	@OneToMany(mappedBy="politicalparty",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<PoliticalLeader> politicalLeaders;
	
	public Set<PoliticalLeader> getPoliticalLeaders() {
		return politicalLeaders;
	}

	public void setPoliticalLeaders(Set<PoliticalLeader> politicalLeaders) {
		this.politicalLeaders = politicalLeaders;
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
	public Long getfoundationYear() {
		return foundationYear;
	}

	public void setfoundationYear(Long foundationYear) {
		this.foundationYear = foundationYear;
	}
	
	/*
	 * public Long getPoliticalLeaderId() { return politicalLeaderId; }
	 * 
	 * public void setPoliticalLeaderId(Long politicalLeaderId) {
	 * this.politicalLeaderId = politicalLeaderId; }
	 */

}
