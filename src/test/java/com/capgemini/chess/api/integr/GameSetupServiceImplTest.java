package com.capgemini.chess.api.integr;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.api.GameSetupService;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.objects.ChallengeTO;
import com.capgemini.chess.service.to.objects.StatsTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfigurationForTest.class, ChessApplication.class})
public class GameSetupServiceImplTest {

	
	@Autowired
	private GameSetupService gameSetupService;

	
	@Test
	public void shouldReturnFivePossibleChallenges() 
			throws NoSuchUserException {
		
		// given
		long myselfID = 1L;
		
		// when
		List<ChallengeTO> challenges = gameSetupService.suggestFivePossibleChallenges(myselfID);
		
		// then
		assertTrue(challenges.size() == 5);
	}
	
	
	@Test
	public void shouldReturnThrownChallengeInSuggestions() 
			throws NoSuchUserException {
		
		// given
		long myselfID = 3L;
		
		// when
		ChallengeTO challenge = gameSetupService.setupChallenge(3L, 5L);
		List<ChallengeTO> challenges = gameSetupService.suggestFivePossibleChallenges(myselfID);
		
		// then
		assertTrue(challenges.contains(challenge));
	}

	
	@Test
	public void shouldSuggestChallengesForMyLevel() 
			throws NoSuchUserException {
		
		// given
		long myselfID = 9L;
		
		// when
		List<ChallengeTO> challenges = gameSetupService.suggestFivePossibleChallenges(myselfID);
		
		// then
		assertTrue(challenges.size() == 3);
	}
	

	@Test
	public void shouldReturnChallengeAsAcceptedAfterSetupChallnge() 
			throws NoSuchUserException {
		
		// given
		long myselfID = 4L;
		
		// when
		ChallengeTO challenge = gameSetupService.setupChallenge(1L, 4L);
		List<ChallengeTO> challenges = gameSetupService.suggestFivePossibleChallenges(myselfID);
		
		// then
		assertEquals(ChallengeStatus.ACCEPTED, challenge.getStatus());
		assertFalse(challenges.contains(challenge));
	}
	
	
	@Test
	public void shouldShowStatsForUsersFromChallengeSuggestion() 
			throws NoSuchUserException {
		
		// given
		long myselfID = 7L;
		
		// when
		List<ChallengeTO> challenges = gameSetupService.suggestFivePossibleChallenges(myselfID);
		Long[] userIds = {challenges.get(0).getCallingUser(), challenges.get(0).getDefendingUser()};
		List<StatsTO> statsTo = gameSetupService.showUserStats(userIds);
		
		// then
		assertEquals("marco24", statsTo.get(0).getLogin());
		assertEquals("stefano", statsTo.get(1).getLogin());
	}
	
}
