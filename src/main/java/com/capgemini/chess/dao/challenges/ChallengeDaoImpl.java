package com.capgemini.chess.dao.challenges;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.capgemini.chess.dao.ChallengeEntity;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.service.to.mapper.CommonMapper;
import com.capgemini.chess.service.to.objects.ChallengeTO;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	private final Set<ChallengeEntity> challenges;

	public ChallengeDaoImpl() {
		this.challenges = new HashSet<>();
		System.err.println("CHALLENGE REPOSITORY CONTENT:");
		this.challenges.forEach(System.err::println);
	}
	
	public ChallengeDaoImpl(Set<ChallengeEntity> challenges) {
		this.challenges = challenges;
		System.err.println("CHALLENGE REPOSITORY CONTENT:");
		this.challenges.forEach(System.err::println);
	}
	

	@Override
	public Set<ChallengeTO> findByDefendingUser(Long defendingId, ChallengeStatus status) {
		return challenges.stream().filter(c -> (c.getDefendingUser().equals(defendingId) 
				&& c.getStatus().equals(status))).map(CommonMapper::map).collect(Collectors.toSet());
	}
	
	@Override
	public boolean checkIfContraChallengeExists(Long defendingId, Long callingId) {
		return challenges.stream().anyMatch(c -> (c.getDefendingUser().equals(callingId) 
				&& c.getCallingUser().equals(defendingId) && c.getStatus() == ChallengeStatus.THROWN));
	}
	
	@Override
	public ChallengeTO acceptExistContraChallenge(Long defendingId, Long callingId) {
		ChallengeEntity challenge = challenges.stream().filter(c -> (c.getDefendingUser().equals(callingId)
				&& c.getCallingUser().equals(defendingId) && c.getStatus() == ChallengeStatus.THROWN)).findFirst().orElse(null);
		challenge.setStatus(ChallengeStatus.ACCEPTED);
		return CommonMapper.map(challenge);
	}

	@Override
	public ChallengeTO setupNewChallenge(Long defendingId, Long callingId) {
		ChallengeEntity challenge = new ChallengeEntity();
		challenge.setDefendingUser(defendingId);
		challenge.setCallingUser(callingId);
		challenge.setStatus(ChallengeStatus.THROWN);
		challenges.add(challenge);
		return CommonMapper.map(challenge);
	}
	
}
