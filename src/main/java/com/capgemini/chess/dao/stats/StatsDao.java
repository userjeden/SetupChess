package com.capgemini.chess.dao.stats;
import com.capgemini.chess.service.to.objects.StatsTO;

public interface StatsDao {
	

	public StatsTO readStatsByID(Long id);
	
	public StatsTO readStatsByLogin(String login);
}
