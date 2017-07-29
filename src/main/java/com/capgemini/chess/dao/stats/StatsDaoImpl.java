package com.capgemini.chess.dao.stats;
import java.util.HashSet;
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
		System.err.println("STATS REPOSITORY CONTENT:");
		this.users.forEach(System.err::println);
	}
	
	public StatsDaoImpl(Set<UserEntity> users){
		this.users = users;
		System.err.println("STATS REPOSITORY CONTENT:");
		this.users.forEach(System.err::println);
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

}
