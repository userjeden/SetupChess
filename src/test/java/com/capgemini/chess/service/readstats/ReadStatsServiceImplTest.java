package com.capgemini.chess.service.readstats;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.capgemini.chess.dao.UserEntity;
import com.capgemini.chess.dao.stats.StatsDao;
import com.capgemini.chess.dao.stats.StatsDaoImpl;
import com.capgemini.chess.exceptions.NoSuchUserException;
import com.capgemini.chess.service.to.mapper.CommonMapper;
import com.capgemini.chess.service.to.objects.StatsTO;

@RunWith(MockitoJUnitRunner.class)
public class ReadStatsServiceImplTest {

	
	private StatsDao statsDaoId;
	private StatsDao statsDaoLogin;
	
	@Before
	public void prepareDaoId(){
		statsDaoId = mock(StatsDaoImpl.class);
		when(statsDaoId.readStatsByID(1L)).thenReturn(CommonMapper.mapForStats(new UserEntity(1L, "marco24", 1)));
		when(statsDaoId.readStatsByID(2L)).thenReturn(CommonMapper.mapForStats(new UserEntity(2L, "mona", 3)));
		when(statsDaoId.readStatsByID(3L)).thenReturn(CommonMapper.mapForStats(new UserEntity(3L, "rocky", 2)));
	}
	
	@Before
	public void prepareDaoLogin(){
		statsDaoLogin = mock(StatsDaoImpl.class);
		when(statsDaoLogin.readStatsByLogin("marco24")).thenReturn(CommonMapper.mapForStats(new UserEntity(1L, "marco24", 1)));
		when(statsDaoLogin.readStatsByLogin("mona")).thenReturn(CommonMapper.mapForStats(new UserEntity(2L, "mona", 3)));
		when(statsDaoLogin.readStatsByLogin("rocky")).thenReturn(CommonMapper.mapForStats(new UserEntity(3L, "rocky", 2)));
	}
	
	
	@Test
	public void shouldReadStatsForID() throws NoSuchUserException{
		
		// given
		ReadStatsService readStatsService = new ReadStatsServiceImpl(statsDaoId);

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
		ReadStatsService readStatsService = new ReadStatsServiceImpl(statsDaoLogin);

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
		ReadStatsService readStatsService = new ReadStatsServiceImpl(statsDaoId);

		// when
		StatsTO statsA = null;;
		try {
			statsA = readStatsService.getStatsByID(4L);
		} catch (NoSuchUserException e) {
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
		ReadStatsService readStatsService = new ReadStatsServiceImpl(statsDaoId);

		// when
		StatsTO statsA = null;;
		try {
			statsA = readStatsService.getStatsByLogin("lulu");
		} catch (NoSuchUserException e) {
			exceptionThrown = true;
		}
		
		// then
		assertTrue(statsA == null);
		assertTrue(exceptionThrown);
	}
	
	
}
