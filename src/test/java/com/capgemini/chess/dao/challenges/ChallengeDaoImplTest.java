package com.capgemini.chess.dao.challenges;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.api.integr.DatabaseConfigurationForTest;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.service.to.objects.ChallengeTO;

@RunWith(MockitoJUnitRunner.class)
public class ChallengeDaoImplTest {

	
	private ChallengeDao challengeDao;

	@Before
	public void prepareUserDao(){
		DatabaseConfigurationForTest daoConfig = new DatabaseConfigurationForTest();
		challengeDao = daoConfig.prepareChallengeDao();
	}
	
	
	@Test
	public void shouldFindByDefendingUser(){
		
		// when
		Set<ChallengeTO> challenges = challengeDao.findByDefendingUser(4L, ChallengeStatus.THROWN);

		// then
		assertEquals(2, challenges.size());
	}
		
	
	@Test
	public void shouldCheckIfContraChallengeExists(){
		
		// when
		boolean challengeExists = challengeDao.checkIfContraChallengeExists(2L, 4L);

		// then
		assertTrue(challengeExists);
	}

	
	@Test
	public void shouldAcceptExistingChallenge(){
		
		// when
		ChallengeTO challenge = challengeDao.acceptExistContraChallenge(1L, 7L);

		// then
		Set<ChallengeTO> challenges = challengeDao.findByDefendingUser(7L, ChallengeStatus.ACCEPTED);
		assertTrue(challenge.getStatus() == ChallengeStatus.ACCEPTED);
		assertTrue(challenges.contains(challenge));
	}
	

	@Test
	public void shouldSetupNewChallenge(){
		
		// when
		ChallengeTO challenge = challengeDao.setupNewChallenge(3L, 5L);

		// then
		Set<ChallengeTO> challenges = challengeDao.findByDefendingUser(3L, ChallengeStatus.THROWN);
		assertTrue(challenge.getStatus() == ChallengeStatus.THROWN);
		assertTrue(challenges.contains(challenge));
	}	
	
	
}

