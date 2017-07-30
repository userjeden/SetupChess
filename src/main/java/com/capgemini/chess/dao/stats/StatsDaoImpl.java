package com.capgemini.chess.dao.stats;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.UserEntity;
import com.capgemini.chess.service.to.mapper.CommonMapper;
import com.capgemini.chess.service.to.objects.StatsTO;

@Repository
public class StatsDaoImpl implements StatsDao {

	private final Set<UserEntity> users;

	public StatsDaoImpl() {
		this.users = new HashSet<>();
		System.out.println("STATS REPOSITORY CONTENT:");
		this.users.forEach(System.out::println);
	}
	
	public StatsDaoImpl(Set<UserEntity> users){
		this.users = users;
		System.out.println("STATS REPOSITORY CONTENT:");
		this.users.forEach(System.out::println);
	}
	
	
	@Override
	public StatsTO readStatsByID(Long id) {
		UserEntity user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return CommonMapper.mapForStats(user);
	}
	
	@Override
	public StatsTO readStatsByLogin(String login) {
		UserEntity user = users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
		return CommonMapper.mapForStats(user);
	}

	@Override
	public List<StatsTO> readStatsByID(Long[] ids) {
		List<StatsTO> userList = new ArrayList<>();
		for(Long id : ids){
			userList.add(readStatsByID(id));
		}
		return userList;
	}

}
