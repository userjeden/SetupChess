package com.capgemini.chess.dao.statsusers;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.chess.api.integr.DatabaseConfigurationForTest;
import com.capgemini.chess.dao.users.UserDao;
import com.capgemini.chess.service.to.objects.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {

	
	private UserDao userDao;

	@Before
	public void prepareUserDao(){
		DatabaseConfigurationForTest daoConfig = new DatabaseConfigurationForTest();
		userDao = daoConfig.prepareUserDao();
	}
	
	
	@Test
	public void shouldReadUserByID(){
		
		// when
		UserTO user = userDao.readUserByID(3L);

		// then
		assertEquals("rocky", user.getLogin());
	}
		
	
	@Test
	public void shouldReadUserByLogin(){
		
		// when
		UserTO user = userDao.readUserByLogin("rocky");

		// then
		assertEquals(Long.valueOf(3), user.getId());
	}
	

	@Test
	public void shouldReadUsersByRank(){
		
		// when
		List<UserTO> users = userDao.readUsersByRank(5, 2);

		// then
		users.forEach(System.out::println);
		assertEquals(3, users.size());
	}
	
	
	@Test
	public void shouldNOTReadUserByIDreturnNull() {
		
		// when
		UserTO user = userDao.readUserByID(6L);

		// then
		assertTrue(user == null);
	}
	
}

