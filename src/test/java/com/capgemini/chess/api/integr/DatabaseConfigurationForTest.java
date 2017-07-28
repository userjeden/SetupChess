package com.capgemini.chess.api.integr;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.capgemini.chess.dao.ChallengeEntity;
import com.capgemini.chess.dao.UserEntity;
import com.capgemini.chess.dao.challenges.ChallengeDao;
import com.capgemini.chess.dao.challenges.ChallengeDaoImpl;
import com.capgemini.chess.dao.usersstats.UserDao;
import com.capgemini.chess.dao.usersstats.UserDaoImpl;
import com.capgemini.chess.enums.ChallengeStatus;

@Configuration
public class DatabaseConfigurationForTest {
	
	@Bean
	@Primary
	public UserDao prepareUserDao() {
		List<UserEntity> users = new ArrayList<>();
		users.add(new UserEntity(1L, "marco24", 1));
		users.add(new UserEntity(2L, "mona", 2));
		users.add(new UserEntity(3L, "rocky", 2));
		users.add(new UserEntity(4L, "supermen", 1));
		users.add(new UserEntity(5L, "lulu", 3));
		users.add(new UserEntity(7L, "stefano", 2));
		users.add(new UserEntity(8L, "wymiatacz", 4));
		users.add(new UserEntity(9L, "mistrz", 5));
		return new UserDaoImpl(users);
	}
	
	@Bean
	@Primary
	public ChallengeDao prepareChallengeDao() {
		List<ChallengeEntity> challenges = new ArrayList<>();
		challenges.add(new ChallengeEntity(1L, 4L, ChallengeStatus.THROWN));
		challenges.add(new ChallengeEntity(1L, 7L, ChallengeStatus.THROWN));
		challenges.add(new ChallengeEntity(1L, 9L, ChallengeStatus.THROWN));
		challenges.add(new ChallengeEntity(2L, 4L, ChallengeStatus.THROWN));
		challenges.add(new ChallengeEntity(2L, 9L, ChallengeStatus.OUTDATED));
		return new ChallengeDaoImpl(challenges);
	}
	
}
