package com.capgemini.chess.dao.usersstats;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.UserEntity;
import com.capgemini.chess.service.to.mapper.CommonMapper;
import com.capgemini.chess.service.to.objects.StatsTO;
import com.capgemini.chess.service.to.objects.UserTO;

@Repository
public class UserDaoImpl implements UserDao {

	private final Set<UserEntity> users = new HashSet<>();

	public UserDaoImpl() {
	}
	
	public UserDaoImpl(List<UserEntity> users) {
		this.users.addAll(users);
	}

	
	@Override
	public UserTO readUserByID(Long id) {
		UserEntity user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return CommonMapper.map(user);
	}
	
	@Override
	public StatsTO readStatsByID(Long id) {
		UserEntity user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return CommonMapper.mapForStats(user);
	}

	@Override
	public UserTO readUserByLogin(String login) {
		UserEntity user = users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
		return CommonMapper.map(user);
	}
	
	@Override
	public StatsTO readStatsByLogin(String login) {
		UserEntity user = users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
		return CommonMapper.mapForStats(user);
	}

	@Override
	public List<UserTO> readUsersByRank(int rank, int range) {
		List<UserEntity> userEntities = users.stream().filter(u -> ((u.getUserValue() <= rank + range) 
				&& (u.getUserValue() >= rank - range))).collect(Collectors.toList());
		return CommonMapper.map2TOs(userEntities);
	}

}
