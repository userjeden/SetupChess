package com.capgemini.chess.dao.users;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.UserEntity;
import com.capgemini.chess.service.to.mapper.CommonMapper;
import com.capgemini.chess.service.to.objects.UserTO;

@Repository
public class UserDaoImpl implements UserDao {

	private final Set<UserEntity> users;

	public UserDaoImpl() {
		this.users = new HashSet<>();
		System.err.println("USER REPOSITORY CONTENT:");
		this.users.forEach(System.err::println);
	}
	
	public UserDaoImpl(Set<UserEntity> users){
		this.users = users;
		System.err.println("USER REPOSITORY CONTENT:");
		this.users.forEach(System.err::println);
	}

	
	@Override
	public UserTO readUserByID(Long id) {
		UserEntity user = users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
		return CommonMapper.map(user);
	}

	@Override
	public UserTO readUserByLogin(String login) {
		UserEntity user = users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
		return CommonMapper.map(user);
	}

	@Override
	public List<UserTO> readUsersByRank(int rank, int range) {
		List<UserEntity> userEntities = users.stream().filter(u -> ((u.getUserValue() <= rank + range) 
				&& (u.getUserValue() >= rank - range))).collect(Collectors.toList());
		return CommonMapper.map2TOs(userEntities);
	}

}
