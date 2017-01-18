package org.cintia.cbottle.web.controller;

import java.util.Arrays;
import java.util.List;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CustomerControllerTest {
	
	private static final String CUSTOMER_MAPPING = "/customers";
	
	@InjectMocks
	private CustomerController controller;
	
	@Mock
	private CustomerDAO mockCustomerDAO;
	
	@Mock
	private View view;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(view).build();
	}
	
	@Test
	public void testListCustomers() throws Exception {
		List<Customer> expected = Arrays.asList(new Customer());
		when(mockCustomerDAO.getAll()).thenReturn(expected);
		
		mockMvc.perform(get(CUSTOMER_MAPPING)).andExpect(status().isOk()).andExpect(view().name("customers"));
	}
}
