package com.konxsys.chucknorris;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

public class AppHeader extends HorizontalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppHeader() {
		setHeight("67px");
    	getStyle().set("backgroundColor", "#37474F");
    	setWidth("100%");
    	
    	setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
    	
    	Button homeButton = new Button(new Icon(VaadinIcon.HOME_O));
    	homeButton.getIcon().getElement().getClassList().add("size-l");
    	homeButton.addClickListener( e-> {
        	homeButton.getUI().ifPresent(ui -> ui.navigate(""));
         });
    	add(homeButton);
	}

}
