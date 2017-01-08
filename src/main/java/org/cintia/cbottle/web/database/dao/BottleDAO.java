package org.cintia.cbottle.web.database.dao;

import org.cintia.cbottle.web.database.DataAccess;
import org.cintia.cbottle.web.domain.Bottle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BottleDAO implements DataAccess<Bottle>{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	RowMapper<Bottle> rowMapper;
}
