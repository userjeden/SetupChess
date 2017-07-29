package com.capgemini.chess.dao.users;
import java.util.List;
import com.capgemini.chess.service.to.objects.UserTO;

public interface UserDao {
	

	public UserTO readUserByID(Long id);
	
	public UserTO readUserByLogin(String login);
	
	public List<UserTO> readUsersByRank(int rank, int range);
}
