package com.capgemini.chess.service.readstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.usersstats.UserDao;
import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.objects.StatsTO;

@Service
public class ReadStatsServiceImpl implements ReadStatsService {

	private UserDao userDao;
	
	@Autowired
	public ReadStatsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	

	@Override
	public StatsTO getStatsByID(Long id) throws NoSuchUserException {
		StatsTO stats = userDao.readStatsByID(id);
		if(stats == null){
			throw new NoSuchUserException();
		}
		return stats;
	}

	
	@Override
	public StatsTO getStatsByLogin(String login) throws NoSuchUserException {
		StatsTO stats = userDao.readStatsByLogin(login);
		if(stats == null){
			throw new NoSuchUserException();
		}
		return stats;
	}

}
