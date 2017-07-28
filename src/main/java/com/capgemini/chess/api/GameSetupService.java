package com.capgemini.chess.api;

import java.util.List;
import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.objects.ChallengeTO;
import com.capgemini.chess.service.to.objects.StatsTO;

public interface GameSetupService {
	
	
	/*
	 * Prepares a list of maximum 5 possible challenges. Primarily the list 
	 * includes challenges called on the user. Then the list is filled with 
	 * suggestions of other possible challenges.
	 */
	public List<ChallengeTO> suggestFivePossibleChallenges(long myselfId) 
			throws NoSuchUserException;
	
	
	/*
	 * Creates a challenge for the specified calling user and defending user.
	 * If the contrary challenge already exists - then the challenge
	 * is automatically accepted.
	 */
	public ChallengeTO setupChallenge(long defendingId, long callingId) 
			throws NoSuchUserException;
	
	
	/*
	 * Brings statistics for the given user.
	 */
	public StatsTO showUserStats(long userId) throws NoSuchUserException;
	
}

