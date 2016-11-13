package org.cintia.cbottle.web.database.dao;

import java.math.BigDecimal;

import org.cintia.cbottle.web.database.query.CustomerQuery;
import org.cintia.cbottle.web.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CustomerQuery.class)
public class CustomerDAOTest {
	
	private static final String EMAIL = "emailaddress@gmail.com";
	private static final String NAME = "Kate";
	private static final String PASSWORD = "password";
	private static final String MOBILE_NUMBER = "333 666 9988";
	private static final BigDecimal ACCOUNT_BALANCE = BigDecimal.ZERO;
	private static final boolean LOYALTY = false;
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@Mock
	private RowMapper<Customer> customerRowMapper;
	
	@InjectMocks
	private CustomerDAO customerDAO;
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testInsert() {
		//given
		PowerMockito.mockStatic(CustomerQuery.class);
		Customer customer = new Customer(EMAIL, NAME, PASSWORD, MOBILE_NUMBER, ACCOUNT_BALANCE , LOYALTY);
		Object[] mockInsertParams = new Object[0];
		BDDMockito.given(CustomerQuery.mapInsertParams(customer)).willReturn(mockInsertParams);
		
		//when
		customerDAO.insert(customer);
		
		//then
		Mockito.verify(jdbcTemplate).update(CustomerQuery.INSERT.sql(), mockInsertParams);
	}
	
	@Test
	public void testDelete() {
		customerDAO.delete(EMAIL);
		Mockito.verify(jdbcTemplate).update(CustomerQuery.DELETE.sql(), EMAIL);
	}
}
