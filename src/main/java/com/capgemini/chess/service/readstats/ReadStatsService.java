package com.capgemini.chess.service.readstats;

import java.util.List;

import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.objects.StatsTO;

public interface ReadStatsService {

	
	public StatsTO getStatsByID(Long id) throws NoSuchUserException;
	
	public StatsTO getStatsByLogin(String login) throws NoSuchUserException;

	public List<StatsTO> getStatsByID(Long[] userIds) throws NoSuchUserException;
}
