package com.capgemini.chess.dao.statsusers;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import com.capgemini.chess.api.integr.DatabaseConfigurationForTest;
import com.capgemini.chess.dao.stats.StatsDao;
import com.capgemini.chess.service.to.objects.StatsTO;

@RunWith(MockitoJUnitRunner.class)
public class StatsDaoImplTest {

	
	private StatsDao statsDao;

	@Before
	public void prepareStatsDao(){
		DatabaseConfigurationForTest daoConfig = new DatabaseConfigurationForTest();
		statsDao = daoConfig.prepareStatsDao();
	}
	
	
	@Test
	public void shouldReadUserByID(){
		
		// when
		StatsTO stats = statsDao.readStatsByID(3L);

		// then
		assertEquals("rocky", stats.getLogin());
	}
		
	
	@Test
	public void shouldReadStatsByLogin(){
		
		// when
		StatsTO stats = statsDao.readStatsByLogin("rocky");

		// then
		assertEquals(Long.valueOf(3), stats.getId());
	}
	
	
	@Test
	public void shouldNOTReadStatsByIDreturnNull() {
		
		// when
		StatsTO stats = statsDao.readStatsByID(6L);

		// then
		assertTrue(stats == null);
	}
	
	
	@Test
	public void shouldNOTReadStatsByLoginReturnNull() {
		
		// when
		StatsTO stats = statsDao.readStatsByLogin("noSuchLogin");

		// then
		assertTrue(stats == null);
	}
	
}

