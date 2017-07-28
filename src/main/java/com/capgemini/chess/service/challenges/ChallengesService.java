package com.capgemini.chess.service.challenges;

import java.util.List;
import com.capgemini.chess.service.to.objects.ChallengeTO;

public interface ChallengesService {

	
	public List<ChallengeTO> suggestFivePossibleChallenges(Long myselfId);

	public ChallengeTO setupChallenge(Long defendingId, Long callingId);
}
