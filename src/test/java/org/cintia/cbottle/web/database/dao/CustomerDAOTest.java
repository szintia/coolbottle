package org.cintia.cbottle.web.database.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.cintia.cbottle.web.database.query.CustomerQuery;
import org.cintia.cbottle.web.domain.Customer;
import org.junit.Assert;
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
	private static final String LOYALTY = "N";
	private static final Customer CUSTOMER = new Customer(EMAIL, NAME, PASSWORD, MOBILE_NUMBER, ACCOUNT_BALANCE, LOYALTY);
	private static final List<Customer> CUSTOMERS = Arrays.asList(CUSTOMER);
	
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
		Object[] mockInsertParams = new Object[0];
		BDDMockito.given(CustomerQuery.mapInsertParams(CUSTOMER)).willReturn(mockInsertParams);
		
		//when
		customerDAO.insert(CUSTOMER);
		
		//then
		Mockito.verify(jdbcTemplate).update(CustomerQuery.INSERT.sql(), mockInsertParams);
	}
	
	@Test
	public void testDelete() {
		customerDAO.delete(EMAIL);
		Mockito.verify(jdbcTemplate).update(CustomerQuery.DELETE.sql(), EMAIL);
	}
	
	@Test
	public void testFindById() {
		BDDMockito.given(jdbcTemplate.queryForObject(CustomerQuery.SELECT_BY_EMAIL.sql(), customerRowMapper, EMAIL)).willReturn(CUSTOMER);
		
		Assert.assertEquals(customerDAO.findById(EMAIL), CUSTOMER);
	}
	
	@Test
	public void testGetAll() {
		BDDMockito.given(jdbcTemplate.query(CustomerQuery.SELECT_ALL.sql(), customerRowMapper)).willReturn(CUSTOMERS);
		
		Assert.assertEquals(customerDAO.getAll(), CUSTOMERS);
	}
}
