package com.capgemini.chess.dao.usersstats;

import java.util.List;

import com.capgemini.chess.service.to.objects.StatsTO;
import com.capgemini.chess.service.to.objects.UserTO;

public interface UserDao {
	

	public UserTO readUserByID(Long id);
	
	public StatsTO readStatsByID(Long id);
	
	public UserTO readUserByLogin(String login);
	
	public StatsTO readStatsByLogin(String login);
	
	public List<UserTO> readUsersByRank(int rank, int range);
}
