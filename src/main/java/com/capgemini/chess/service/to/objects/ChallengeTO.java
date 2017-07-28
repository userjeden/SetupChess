package com.capgemini.chess.service.to.objects;
import com.capgemini.chess.enums.ChallengeStatus;

public class ChallengeTO {

	private Long callingUser;
	private Long defendingUser;
	private ChallengeStatus status;
	
	
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
		return "CHALLENGE_TO defending: " + defendingUser + ", calling: " + callingUser +  ", status: " + status;
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
		ChallengeTO other = (ChallengeTO) obj;
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
