package com.capgemini.chess.service.readstats;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.stats.StatsDao;
import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.objects.StatsTO;

@Service
public class ReadStatsServiceImpl implements ReadStatsService {

	private StatsDao statsDao;
	
	@Autowired
	public ReadStatsServiceImpl(StatsDao statsDao) {
		this.statsDao = statsDao;
	}
	

	@Override
	public StatsTO getStatsByID(Long id) throws NoSuchUserException {
		StatsTO stats = statsDao.readStatsByID(id);
		if(stats == null){
			throw new NoSuchUserException();
		}
		return stats;
	}

	
	@Override
	public StatsTO getStatsByLogin(String login) throws NoSuchUserException {
		StatsTO stats = statsDao.readStatsByLogin(login);
		if(stats == null){
			throw new NoSuchUserException();
		}
		return stats;
	}


	@Override
	public List<StatsTO> getStatsByID(Long[] userIds) throws NoSuchUserException {
		List<StatsTO> statsList = statsDao.readStatsByID(userIds);
		if(statsList.size() != userIds.length){
			throw new NoSuchUserException();
		}
		return statsList;
	}

}
