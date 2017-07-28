package com.capgemini.chess.dao;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.capgemini.chess.enums.ChallengeStatus;

@Entity
public class ChallengeEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long callingUser;
	private Long defendingUser;
	private ChallengeStatus status;
	
	public ChallengeEntity(){
	}
	
	public ChallengeEntity(Long callingUser, Long defendingUser, ChallengeStatus status) {
		this.callingUser = callingUser;
		this.defendingUser = defendingUser;
		this.status = status;
	}

	
	public Long getDefendingUser() {
		return Long.valueOf(defendingUser);
	}
	
	public void setDefendingUser(Long defendingUser) {
		this.defendingUser = Long.valueOf(defendingUser);
	}
	
	public Long getCallingUser() {
		return Long.valueOf(callingUser);
	}
	
	public void setCallingUser(Long callingUser) {
		this.callingUser = Long.valueOf(callingUser);
	}
	
	public ChallengeStatus getStatus() {
		return status;
	}
	
	public void setStatus(ChallengeStatus status) {
		this.status = status;
	}
	
	
	@Override
	public String toString(){
		return "CHALLENGE_ENT defending: " + defendingUser + ", calling: " + callingUser +  ", status: " + status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callingUser == null) ? 0 : callingUser.hashCode());
		result = prime * result + ((defendingUser == null) ? 0 : defendingUser.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChallengeEntity other = (ChallengeEntity) obj;
		if (callingUser == null) {
			if (other.callingUser != null)
				return false;
		} else if (!callingUser.equals(other.callingUser))
			return false;
		if (defendingUser == null) {
			if (other.defendingUser != null)
				return false;
		} else if (!defendingUser.equals(other.defendingUser))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
