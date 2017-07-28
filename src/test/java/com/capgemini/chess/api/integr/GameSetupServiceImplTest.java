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
		assertEquals(5, challenges.size());
		assertTrue((challenges.get(0).getStatus() == ChallengeStatus.THROWN) 
				|| (challenges.get(0).getStatus() == ChallengeStatus.POTENTIAL));
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
		challenges.forEach(System.out::println);
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
		challenges.forEach(System.out::println);
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
		assertTrue(challenge.getStatus() == ChallengeStatus.ACCEPTED);
		assertFalse(challenges.contains(challenge));
		challenges.forEach(System.out::println);
	}
	
	
	@Test
	public void shouldShowStatsForUserFromChallengeSuggestion() 
			throws NoSuchUserException {
		
		// given
		long myselfID = 7L;
		
		// when
		List<ChallengeTO> challenges = gameSetupService.suggestFivePossibleChallenges(myselfID);
		StatsTO statsTo = gameSetupService.showUserStats(challenges.get(0).getCallingUser());
		
		// then
		assertTrue(statsTo.getId() == 1);
		assertTrue(statsTo.getLogin() == "marco24");
	}
	
	
}

