package com.konxsys.chucknorris.backend;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service to communicate with the themoviedb.org API
 * 
 * Get a reference to this service class with {@link MovieService#getInstance()}.
 */
public class MovieService {

	private static MovieService instance;
	private static final Logger LOGGER = Logger.getLogger(MovieService.class.getName());
	private static final String THEMOVIEDB = "https://api.themoviedb.org/";

	private MovieService() {
		//required for chucknorris.io to accept connection
    	System.setProperty("http.agent", "Chrome");
	}

	/**
	 * @return a reference to an example facade for Fact objects.
	 */
	public static MovieService getInstance() {
		if (instance == null) {
			instance = new MovieService();
		}
		return instance;
	}

	
	/**
	 * Get all Joke Categories.
	 *
	 * @return String array with categories
	 */

	public synchronized List <Movie> getMovies() {
		ObjectMapper objectMapper = new ObjectMapper();
		URL url;
		List<Movie> movies = null;
		try {
			url = new URL(THEMOVIEDB + "3/person/51576/movie_credits?language=en-US&api_key=57d5022b5338dd529746ec63b42f68d6");
			JsonNode jsonRoot = objectMapper.readTree(url);
			JsonNode cast = jsonRoot.get("cast");
			movies = Arrays.asList(objectMapper.treeToValue(cast,Movie[].class));
			
		} catch (MalformedURLException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, null, ex);
		}

		return movies;
	}
}