package com.capgemini.chess.dao.stats;
import java.util.List;

import com.capgemini.chess.service.to.objects.StatsTO;

public interface StatsDao {
	

	public StatsTO readStatsByID(Long id);
	
	public StatsTO readStatsByLogin(String login);

	public List<StatsTO> readStatsByID(Long[] userIds);
}
