package com.konxsys.chucknorris;

import com.konxsys.chucknorris.backend.FactService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route(value="facts", layout=MainLayout.class)
public class FactsView extends VerticalLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FactService factService = FactService.getInstance();
	
	public FactsView() {
		setSizeFull();
		setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
    	getStyle().set("backgroundColor", "#c4cfd4");
    	
		add(new Label("FactsView"));
		
		ComboBox<String> categoryCombo= new ComboBox<>("Category");
		categoryCombo.setItems(factService.getCategories());
		
		TextArea factText = new TextArea("Another fact about Chuck");
		factText.setReadOnly(true);
		factText.setWidth("300px");
		
		Button getFactButton = new Button("Retrieve Fact");
		getFactButton.addClickListener(e-> {
			if (categoryCombo.isEmpty()) {
				factText.setValue(factService.readJoke());
			} else {
				factText.setValue(factService.readJoke(categoryCombo.getValue()));
			}
			
		});

		add(categoryCombo);
		add(getFactButton);
		add(factText);
	}

}
