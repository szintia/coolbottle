package org.cintia.cbottle.web.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.cintia.cbottle.web.database.DataAccess;
import org.cintia.cbottle.web.database.query.BottleQuery;
import org.cintia.cbottle.web.database.query.Query;
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
	
	@Override
	public void insert(Bottle bottle) {
		Object[] paramValues = BottleQuery.mapInsertParams(bottle);
		String insertBottle = BottleQuery.INSERT.sql();
		jdbcTemplate.update(insertBottle, paramValues);
	}
	
	@Override
	public void delete(String id) {
		String deleteBottle = BottleQuery.DELETE.sql();
		jdbcTemplate.update(deleteBottle, id);
	}

	@Override
	public Bottle findById(String id) {
		return null;
	}

	@Override
	public List<Bottle> getAll() {
		return query(BottleQuery.SELECT_ALL);
	}

	@Override
	public List<Bottle> query(Query query, Object... paramValues) {
		String sql = query.sql();
		List<Bottle> listBottle = jdbcTemplate.query(sql, new RowMapper<Bottle>() {
			
			@Override
			public Bottle mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bottle bottle = new Bottle();
				bottle.setProductId(rs.getString("product_id"));
				bottle.setCategoryId(rs.getString("category_id"));
				bottle.setProductName(rs.getString("product_name"));
				bottle.setDescription(rs.getString("description"));
				bottle.setPrice(rs.getBigDecimal("price"));
				bottle.setAmount(rs.getInt("amount"));
				bottle.setDate(rs.getDate("time"));
				return bottle;
			}
		});
		return listBottle;
	}
}
