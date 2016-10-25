package org.cintia.cbottle.web.database;

import java.util.List;

public interface DataAccess<T> {
	
	/**
	 * Inserts a row representing the input data into the database.
	 * 
	 * @param data the data to be saved to the database.
	 * */
	void insert(T data);
	
	/**
	 * Deletes a row representing the data identified by the input id from the database.
	 * 
	 * @param id the identifier of the data to be deleted from the database.
	 * */
	void delete(String id);
	
	/**
	 * Finds the data by searching for it by id.
	 * 
	 * @param id the identifier of the data we search for.
	 * @return the data we search for.
	 * */
	T findById(String id);
	
	/**
	 * Returns all the data.
	 * 
	 * @return A {@link List} of the existing data in the database of type {@link T}.
	 */
	List<T> getAll();
}
