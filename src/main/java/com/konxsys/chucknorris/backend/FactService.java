package com.konxsys.chucknorris.backend;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service to communicate with the chucknorris.io free JSON API for hand curated
 * Chuck Norris facts.
 * 
 * Get a reference to this service class with {@link FactService#getInstance()}.
 */
public class FactService {

	private static FactService instance;
	private static final Logger LOGGER = Logger.getLogger(FactService.class.getName());
	private static final String CHUCKNORRIS = "https://api.chucknorris.io/jokes/";

	private FactService() {
		//required for chucknorris.io to accept connection
    	System.setProperty("http.agent", "Chrome");
	}

	/**
	 * @return a reference to an example facade for Fact objects.
	 */
	public static FactService getInstance() {
		if (instance == null) {
			instance = new FactService();
		}
		return instance;
	}

	/**
	 * Retrieve a random chuck norris joke.
	 * 
	 * @return the joke.
	 */
	public synchronized String readJoke() {

		return retrieveFact(CHUCKNORRIS + "random").getValue();
	}

	/**
	 * Retrieve a random chuck norris joke from a given category.
	 * 
	 * @param category
	 *            name of the category
	 * @return the joke.
	 */
	public synchronized String readJoke(String category) {

		return retrieveFact(CHUCKNORRIS + "random?category=" + category).getValue();

	}

	/**
	 * Retrieve a random chuck norris joke.
	 * 
	 * @param urlString
	 *            full URL text
	 * 
	 * @return Fact containing the joke.
	 */
	private Fact retrieveFact(String urlString) {
		ObjectMapper objectMapper = new ObjectMapper();
		URL url;
		Fact fact = new Fact();
		try {
			url = new URL(urlString);
			fact = objectMapper.readValue(url, Fact.class);
		} catch (MalformedURLException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		} catch (JsonParseException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		} catch (JsonMappingException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(FactService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return fact;
	}

	/**
	 * Get all Joke Categories.
	 *
	 * @return String array with categories
	 */

	public synchronized String[] getCategories() {
		ObjectMapper objectMapper = new ObjectMapper();
		URL url;
		String[] categories = null;
		try {
			url = new URL(CHUCKNORRIS + "categories");
			categories = objectMapper.readValue(url, String[].class);			
		} catch (MalformedURLException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		}

		return categories;
	}
}