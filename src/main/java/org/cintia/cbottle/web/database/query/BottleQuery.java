package org.cintia.cbottle.web.database.query;

import java.text.DateFormat;
import java.util.Date;

import org.cintia.cbottle.web.domain.Bottle;

public enum BottleQuery implements Query {
	
	INSERT("INSERT INTO product (product_id, category_id, product_name, description, price, amount, date) VALUES (?, ?, ?, ?, ?, ?,TO_DATE( ? , 'YYYY-MM-DD'))"),
	SELECT_ALL("SELECT * FROM product"),
	DELETE("DELETE FROM product WHERE product_id = ?");

	private String query;
	private static final Date date = new Date();
	
	private BottleQuery(String query) {
		this.query = query;
	}
	
	@Override
	public String sql() {
		return query;
	}
	
	public static Object[] mapInsertParams(Bottle bottle) {
		String sqlDate = DateFormat.getInstance().format(date);
		Object[] valueParams = {bottle.getProductId(), bottle.getCategoryId(), bottle.getDescription(), bottle.getPrice(), bottle.getAmount(), sqlDate};
		return valueParams;
	}
}
