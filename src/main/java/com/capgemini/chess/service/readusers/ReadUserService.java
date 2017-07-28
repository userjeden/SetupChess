package com.capgemini.chess.service.readusers;

import java.util.List;

import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.objects.UserTO;

public interface ReadUserService {
	
	
	public UserTO getUserByID(Long id) throws NoSuchUserException;
	
	public UserTO getUserByLogin(String login) throws NoSuchUserException;
	
	public List<UserTO> getUsersByRank(int rank, int range);
}
