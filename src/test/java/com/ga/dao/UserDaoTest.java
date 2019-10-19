package com.ga.dao;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.ga.entity.User;
import com.ga.entity.UserRole;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UserDaoTest {
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@InjectMocks
	private User user;
	
	@InjectMocks
	private UserRole userRole;
	
	@InjectMocks
	private UserDaoImpl userDao;
	
	@Mock
	private UserRoleDao userRoleDao;
	
	@Mock
	private SessionFactory sessionFactory;
	
	@Mock
	private Session session;
	
	//make sure you import org.hibernate one
	@Mock
	private Transaction transaction;
	
	
	@SuppressWarnings("deprecation")
	@Mock
    Query<User> query;
	
	@Before
    public void init() {
		when(sessionFactory.getCurrentSession()).thenReturn(session);
	    when(session.getTransaction()).thenReturn(transaction);
	}
    
    @Before
    public void initializeDummyUser() {
        userRole.setRoleId(1);
        userRole.setName("ROLE_ADMIN");
        
        user.setUserId(1L);
        user.setUsername("test");
        user.setPassword("test");
        user.setUserRole(userRole);
    }
    
    @Test
    public void signup_User_Success() {
        when(userRoleDao.getRole(anyString())).thenReturn(userRole);
        
        User tempUser = userDao.signup(user);
        
        assertNotNull(tempUser);
        
        assertEquals(tempUser.getUsername(), user.getUsername());
    }
    
    @Test
    public void login_User_Success() {
    	when(session.createQuery(anyString())).thenReturn(query);
    	when(query.getSingleResult()).thenReturn(user);
        
        User savedUser = userDao.login(user);
        
        assertNotNull("Test returned null object, expected non-null", savedUser);
        assertEquals(savedUser, user);
    }
    
}
