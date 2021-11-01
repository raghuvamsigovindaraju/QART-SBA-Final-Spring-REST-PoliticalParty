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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "politicalleader")
public class PoliticalLeader implements Serializable, Comparable<PoliticalLeader> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long politicalLeaderId;

	private Long politicalPartyId;
	private String leaderName;
	private String leaderState;
	    
	// @ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "party",nullable = false)
	private PoliticalParty politicalparty;
	
	@OneToMany(mappedBy="politicalleader",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Development> developments;
   
	public PoliticalLeader() {
		super();

	}

	public PoliticalLeader(Long politicalLeaderId, Long politicalPartyId, String leaderName, String leaderState,
			PoliticalParty politicalparty) {
		super();
		this.politicalLeaderId = politicalLeaderId;
		this.politicalPartyId = politicalPartyId;
		this.leaderName = leaderName;
		this.leaderState = leaderState;
		this.politicalparty = politicalparty;
	}

	public Set<Development> getDevelopments() {
		return developments;
	}

	public void setDevelopments(Set<Development> developments) {
		this.developments = developments;
	}

	public PoliticalParty getPoliticalparty() {
		return politicalparty;
	}

	public void setPoliticalparty(PoliticalParty politicalparty) {
		this.politicalparty = politicalparty;
	}

	public Long getPoliticalLeaderId() {
		return politicalLeaderId;
	}

	public void setPoliticalLeaderId(Long candidateId) {
		this.politicalLeaderId = candidateId;
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
	public int compareTo(PoliticalLeader o) {

		return this.politicalLeaderId.compareTo(o.politicalLeaderId);

	}

}
