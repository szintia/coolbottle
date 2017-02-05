package org.cintia.cbottle.web.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cintia.cbottle.web.domain.Bottle;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BottleRowMapper implements RowMapper<Bottle>{

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
}
