package com.capgemini.chess.dao.challenges;
import java.util.Set;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.service.to.objects.ChallengeTO;

public interface ChallengeDao {

	
	public Set<ChallengeTO> findByDefendingUser(Long defndingId, ChallengeStatus status);

	public boolean checkIfContraChallengeExists(Long defndingId, Long callingId);

	public ChallengeTO acceptExistContraChallenge(Long defndingId, Long callingId);

	public ChallengeTO setupNewChallenge(Long defndingId, Long callingId);
}
