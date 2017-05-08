package org.cintia.cbottle.web.controller;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.cintia.cbottle.web.database.dao.BottleDAO;
import org.cintia.cbottle.web.domain.Bottle;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

public class BottleControllerTest {
	
	private static final String BOTTLES_MAPPING = "/bottles";
	private static final String ADD_BOTTLE_MAPPING = "/addBottle";
	private static final String BOTTLES_VIEW = "redirect:/bottles";
	
	@Mock
	private BottleDAO mockBottleDAO;
	
	@Mock
	private View view;
	
	@InjectMocks
	private BottleController mockController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(mockController).setSingleView(view).build();
	}
	
	@Test
	public void testGetAll() throws Exception {
		when(mockBottleDAO.getAll()).thenReturn(Arrays.asList(new Bottle()));
		mockMvc.perform(get(BOTTLES_MAPPING)).andExpect(status().isOk()).andExpect(view().name("bottles"));
		verify(mockBottleDAO).getAll();
	}
	
	@Test
	public void testAddBottle() throws Exception {
		mockMvc.perform(post(ADD_BOTTLE_MAPPING)).andExpect(status().isOk()).andExpect(view().name(BOTTLES_VIEW));
		verify(mockBottleDAO, times(1)).insert(isA(Bottle.class));
	}
}
