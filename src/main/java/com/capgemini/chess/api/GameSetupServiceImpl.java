package com.capgemini.chess.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.challenges.ChallengesService;
import com.capgemini.chess.service.readstats.ReadStatsService;
import com.capgemini.chess.service.to.objects.ChallengeTO;
import com.capgemini.chess.service.to.objects.StatsTO;

@Service
public class GameSetupServiceImpl implements GameSetupService {
	

	private ReadStatsService readStatServ;
	private ChallengesService challengeService;
	
	@Autowired
	public GameSetupServiceImpl(ReadStatsService readStatServ, 
			ChallengesService challengeService) {
		this.readStatServ = readStatServ;
		this.challengeService = challengeService;
	}
	
	
	@Override
	public List<ChallengeTO> suggestFivePossibleChallenges(long myselfId) throws NoSuchUserException {
		return challengeService.suggestFivePossibleChallenges(myselfId);
	}

	@Override
	public ChallengeTO setupChallenge(long defendingId, long callingId) throws NoSuchUserException {
		return challengeService.setupChallenge(defendingId, callingId);
	}

	@Override
	public StatsTO showUserStats(long userId) throws NoSuchUserException {
		return readStatServ.getStatsByID(userId);
	}

}
