package com.capgemini.chess.service.readstats;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.capgemini.chess.dao.UserEntity;
import com.capgemini.chess.dao.usersstats.UserDao;
import com.capgemini.chess.dao.usersstats.UserDaoImpl;
import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.mapper.CommonMapper;
import com.capgemini.chess.service.to.objects.StatsTO;

@RunWith(MockitoJUnitRunner.class)
public class ReadStatsServiceImplTest {

	
	private UserDao userDaoId;
	private UserDao userDaoLogin;
	
	@Before
	public void prepareDaoId(){
		userDaoId = mock(UserDaoImpl.class);
		when(userDaoId.readStatsByID(1L)).thenReturn(CommonMapper.mapForStats(new UserEntity(1L, "marco24", 1)));
		when(userDaoId.readStatsByID(2L)).thenReturn(CommonMapper.mapForStats(new UserEntity(2L, "mona", 3)));
		when(userDaoId.readStatsByID(3L)).thenReturn(CommonMapper.mapForStats(new UserEntity(3L, "rocky", 2)));
	}
	
	@Before
	public void prepareDaoLogin(){
		userDaoLogin = mock(UserDaoImpl.class);
		when(userDaoLogin.readStatsByLogin("marco24")).thenReturn(CommonMapper.mapForStats(new UserEntity(1L, "marco24", 1)));
		when(userDaoLogin.readStatsByLogin("mona")).thenReturn(CommonMapper.mapForStats(new UserEntity(2L, "mona", 3)));
		when(userDaoLogin.readStatsByLogin("rocky")).thenReturn(CommonMapper.mapForStats(new UserEntity(3L, "rocky", 2)));
	}
	
	
	@Test
	public void shouldReadStatsForID() throws NoSuchUserException{
		
		// given
		ReadStatsService readStatsService = new ReadStatsServiceImpl(userDaoId);

		// when
		StatsTO statsA = readStatsService.getStatsByID(1L);
		StatsTO statsB = readStatsService.getStatsByID(2L);
		StatsTO statsC = readStatsService.getStatsByID(3L);
		
		// then
		assertEquals(1, statsA.getUserRank());
		assertEquals(3, statsB.getUserRank());
		assertEquals(2, statsC.getUserRank());
	}
	
	
	@Test
	public void shouldReadStatsForLogin() throws NoSuchUserException{
		
		// given
		ReadStatsService readStatsService = new ReadStatsServiceImpl(userDaoLogin);

		// when
		StatsTO userA = readStatsService.getStatsByLogin("marco24");
		StatsTO userB = readStatsService.getStatsByLogin("mona");
		StatsTO userC = readStatsService.getStatsByLogin("rocky");
		
		// then
		assertEquals(1, userA.getUserRank());
		assertEquals(3, userB.getUserRank());
		assertEquals(2, userC.getUserRank());
	}
	
	
	@Test
	public void shouldNullReadStatsForID(){
		
		// given
		boolean exceptionThrown = false;
		ReadStatsService readStatsService = new ReadStatsServiceImpl(userDaoId);

		// when
		StatsTO statsA = null;;
		try {
			statsA = readStatsService.getStatsByID(4L);
		} catch (NoSuchUserException e) {
		} finally {
			exceptionThrown = true;
		}
		
		// then
		assertTrue(statsA == null);
		assertTrue(exceptionThrown);
	}
	
	
	@Test
	public void shouldNullReadStatsForLogin(){
		
		// given
		boolean exceptionThrown = false;
		ReadStatsService readStatsService = new ReadStatsServiceImpl(userDaoId);

		// when
		StatsTO statsA = null;;
		try {
			statsA = readStatsService.getStatsByLogin("lulu");
		} catch (NoSuchUserException e) {
		} finally {
			exceptionThrown = true;
		}
		
		// then
		assertTrue(statsA == null);
		assertTrue(exceptionThrown);
	}
	
	
}
