package com.konxsys.chucknorris;

import java.util.ArrayList;
import java.util.List;

import com.konxsys.chucknorris.backend.Movie;
import com.konxsys.chucknorris.backend.MovieService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

@Route(value="movies", layout=MainLayout.class)
public class MoviesView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MovieService movieService = MovieService.getInstance();
	private List<Movie> movies;
	
	public MoviesView() {
		setSizeFull();
		getStyle().set("backgroundColor", "#c4cfd4");
		setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
		
		add(new Label("MoviesView"));
		
		movies = new ArrayList<Movie>(movieService.getMovies());
		Grid<Movie> movieGrid = new Grid<>();
		movieGrid.setItems(movies);
		movieGrid.addColumn(new ComponentRenderer<>(Image::new,(image, movie) -> image.setSrc("https://image.tmdb.org/t/p/w185"+movie.getPoster_path())));
		movieGrid.addColumn(Movie::getTitle).setHeader("Title");
		movieGrid.addColumn(Movie::getCharacter).setHeader("Character");
		movieGrid.addColumn(Movie::getRelease_date).setHeader("Release Date");
		movieGrid.setWidth("90%");
		
		//Grid ignores the default alignment
		setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, movieGrid);
		
		add(movieGrid);
	}
	

}
