package org.cintia.cbottle.web.controller;

import java.math.BigDecimal;
import java.util.Arrays;

import org.cintia.cbottle.web.database.dao.CustomerDAO;
import org.cintia.cbottle.web.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CustomerControllerTest {
	
	private static final String CUSTOMER_MAPPING = "/customers";
	private static final String DELETE_CUSTOMER_MAPPING = "/deleteCustomer";
	private static final String REGISTER_MAPPING = "/registerCustomer";
	private static final String CUSTOMER_VIEW = "/home";
	private static final String EMAIL = "email@email.com";
	private static final Customer CUSTOMER = new Customer(EMAIL, "kate", "password", "454454555", BigDecimal.ONE, "N");
	
	@Mock
	private CustomerDAO mockCustomerDAO;
	
	@Mock
	private View view;
	
	@InjectMocks
	private CustomerController controller;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(view).build();
	}
	
	@Test
	public void testListCustomers() throws Exception {
		when(mockCustomerDAO.getAll()).thenReturn(Arrays.asList(new Customer()));
		mockMvc.perform(get(CUSTOMER_MAPPING)).andExpect(status().isOk()).andExpect(view().name("customers"));
		verify(mockCustomerDAO).getAll();
	}
	
	@Test
	public void testRegisterCustomer() throws Exception {
		mockMvc.perform(post(REGISTER_MAPPING, CUSTOMER)).andExpect(status().isOk()).andExpect(view().name(CUSTOMER_VIEW));
		verify(mockCustomerDAO, times(1)).insert(isA(Customer.class));
	}
	
	@Test
	public void testDeleteCustomer() throws Exception {
		mockMvc.perform(get(DELETE_CUSTOMER_MAPPING, EMAIL)).andExpect(status().isOk()).andExpect(view().name(CUSTOMER_VIEW));
		verify(mockCustomerDAO).delete(eq(EMAIL));
	}
}
