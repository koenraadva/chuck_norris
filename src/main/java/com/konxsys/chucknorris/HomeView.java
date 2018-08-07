package com.konxsys.chucknorris;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value="", layout=MainLayout.class)
public class HomeView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeView() {
    	setSizeFull();
    	setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    	getStyle().set("backgroundColor", "#c4cfd4");
    	
    	Image appImage = new Image("frontend/img/chucknorris_logo_coloured_small.png", "Chuck Norris App");
		Label appLabel = new Label("Everything you wanted to know about Chuck Norris");
		
		HorizontalLayout buttonLayout = new HorizontalLayout();
		
        Button factsButton = new Button("Facts");
        factsButton.addClickListener( e-> {
        	factsButton.getUI().ifPresent(ui -> ui.navigate("facts"));
       });
        Button moviesButton = new Button("Movies");
        moviesButton.addClickListener( e-> {
        	moviesButton.getUI().ifPresent(ui -> ui.navigate("movies"));
       });

        buttonLayout.add(factsButton, moviesButton);
        buttonLayout.setWidth("300px");
        buttonLayout.expand(factsButton, moviesButton);
        
        add(appImage, appLabel, buttonLayout);
	}

}
