package com.capgemini.chess.service.readusers;

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
import com.capgemini.chess.service.to.objects.UserTO;

@RunWith(MockitoJUnitRunner.class)
public class ReadUserServiceImplTest {

	
	private UserDao userDaoId;
	private UserDao userDaoLogin;
	
	@Before
	public void prepareDaoId(){
		userDaoId = mock(UserDaoImpl.class);
		when(userDaoId.readUserByID(1L)).thenReturn(CommonMapper.map(new UserEntity(1L, "marco24", 1)));
		when(userDaoId.readUserByID(2L)).thenReturn(CommonMapper.map(new UserEntity(2L, "mona", 2)));
		when(userDaoId.readUserByID(3L)).thenReturn(CommonMapper.map(new UserEntity(3L, "rocky", 3)));
	}
	
	@Before
	public void prepareDaoLogin(){
		userDaoLogin = mock(UserDaoImpl.class);
		when(userDaoLogin.readUserByLogin("marco24")).thenReturn(CommonMapper.map(new UserEntity(1L, "marco24", 1)));
		when(userDaoLogin.readUserByLogin("mona")).thenReturn(CommonMapper.map(new UserEntity(2L, "mona", 2)));
		when(userDaoLogin.readUserByLogin("rocky")).thenReturn(CommonMapper.map(new UserEntity(3L, "rocky", 3)));
	}
	
	
	@Test
	public void shouldReadUserForID() throws NoSuchUserException{
		
		// given
		ReadUserService readUserService = new ReadUserServiceImpl(userDaoId);

		// when
		UserTO userA = readUserService.getUserByID(1L);
		UserTO userB = readUserService.getUserByID(2L);
		UserTO userC = readUserService.getUserByID(3L);
		
		// then
		assertEquals("marco24", userA.getLogin());
		assertEquals("mona", userB.getLogin());
		assertEquals("rocky", userC.getLogin());
	}
	
	
	@Test
	public void shouldReadUserForLogin() throws NoSuchUserException{
		
		// given
		ReadUserService readUserService = new ReadUserServiceImpl(userDaoLogin);

		// when
		UserTO userA = readUserService.getUserByLogin("marco24");
		UserTO userB = readUserService.getUserByLogin("mona");
		UserTO userC = readUserService.getUserByLogin("rocky");
		
		// then
		assertEquals(Long.valueOf(1), userA.getId());
		assertEquals(Long.valueOf(2), userB.getId());
		assertEquals(Long.valueOf(3), userC.getId());
	}
	
	
	@Test
	public void shouldNullReadUserForID(){
		
		// given
		boolean exceptionThrown = false;
		ReadUserService readUserService = new ReadUserServiceImpl(userDaoId);

		// when
		UserTO userA = null;;
		try {
			userA = readUserService.getUserByID(4L);
		} catch (NoSuchUserException e) {
		} finally {
			exceptionThrown = true;
		}
		
		// then
		assertTrue(userA == null);
		assertTrue(exceptionThrown);
	}
	
	
	@Test
	public void shouldNullReadUserForLogin(){
		
		// given
		boolean exceptionThrown = false;
		ReadUserService readUserService = new ReadUserServiceImpl(userDaoLogin);

		// when
		UserTO userA = null;
		try {
			userA = readUserService.getUserByLogin("lulu");
		} catch (NoSuchUserException e) {
		} finally {
			exceptionThrown = true;
		}
		
		// then
		assertTrue(userA == null);
		assertTrue(exceptionThrown);
	}
	
}
