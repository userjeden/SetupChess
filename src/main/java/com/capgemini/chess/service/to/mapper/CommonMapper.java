package com.capgemini.chess.service.to.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.capgemini.chess.dao.ChallengeEntity;
import com.capgemini.chess.dao.UserEntity;
import com.capgemini.chess.service.to.objects.ChallengeTO;
import com.capgemini.chess.service.to.objects.StatsTO;
import com.capgemini.chess.service.to.objects.UserTO;

public class CommonMapper {
	
	
	public static UserTO map(UserEntity user){
		if (user != null){
			UserTO userTo = new UserTO();
			userTo.setId(user.getId());
			userTo.setLogin(user.getLogin());
			userTo.setPassword(user.getPassword());
			userTo.setName(user.getName());
			userTo.setSurname(user.getSurname());
			userTo.setEmail(user.getEmail());
			userTo.setAboutMe(user.getAboutMe());
			userTo.setLifeMotto(user.getLifeMotto());
			userTo.setUserRank(user.getUserValue());
			userTo.setGamesPlayed(user.getGamesPlayed());
			userTo.setGamesWon(user.getGamesWon());
			userTo.setPointsGained(user.getPointsGained());
			return userTo;
		}
		return null;
	}
	
	
	public static StatsTO mapForStats(UserEntity user){
		if (user != null){
			StatsTO statsTo = new StatsTO();
			statsTo.setId(user.getId());
			statsTo.setLogin(user.getLogin());
			statsTo.setUserRank(user.getUserValue());
			statsTo.setGamesPlayed(user.getGamesPlayed());
			statsTo.setGamesWon(user.getGamesWon());
			statsTo.setPointsGained(user.getPointsGained());
			return statsTo;
		}
		return null;
	}
	
	
	public static ChallengeTO map(ChallengeEntity challenge){
		if(challenge != null){
			ChallengeTO challengeTo = new ChallengeTO();
			challengeTo.setCallingUser(challenge.getCallingUser());
			challengeTo.setDefendingUser(challenge.getDefendingUser());
			challengeTo.setStatus(challenge.getStatus());
			return challengeTo;
		}
		return null;
	}
	
	
	public static UserEntity map(UserTO user){
		if(user != null){
			UserEntity userEntity = new UserEntity();
			userEntity.setId(user.getId());
			userEntity.setLogin(user.getLogin());
			userEntity.setPassword(user.getPassword());
			userEntity.setName(user.getName());
			userEntity.setSurname(user.getSurname());
			userEntity.setEmail(user.getEmail());
			userEntity.setAboutMe(user.getAboutMe());
			userEntity.setLifeMotto(user.getLifeMotto());
			return userEntity;
		}
		return null;
	}
	
	
	public static ChallengeEntity map(ChallengeTO challenge){
		if(challenge != null){
			ChallengeEntity challengeEntity = new ChallengeEntity();
			challengeEntity.setCallingUser(challenge.getCallingUser());
			challengeEntity.setDefendingUser(challenge.getDefendingUser());
			challengeEntity.setStatus(challenge.getStatus());
			return challengeEntity;
		}
		return null;
	}
	
	
	public static List<UserTO> map2UserTOs(List<UserEntity> userEntities) {
		return userEntities.stream().map(CommonMapper::map).collect(Collectors.toList());
	}
	
	
	public static List<StatsTO> map2StatsTOs(List<UserEntity> userEntities) {
		return userEntities.stream().map(CommonMapper::mapForStats).collect(Collectors.toList());
	}
	
}
