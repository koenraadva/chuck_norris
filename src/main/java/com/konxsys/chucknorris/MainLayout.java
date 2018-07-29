package com.konxsys.chucknorris;

import java.util.Objects;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view contains buttons for viewing facts or movies.
 */
@BodySize(height = "100vh", width = "100vw")
@Theme(Lumo.class)
@HtmlImport("styles/shared-styles.html")
public class MainLayout extends VerticalLayout implements RouterLayout {

    public MainLayout() {
    	setSizeFull();
    	setSpacing(false);
    	setPadding(false);
        setClassName("main-layout");
        
    }
    
    @Override
    public void showRouterLayoutContent(HasElement content) {
    	removeAll();
    	add(new AppHeader());
    	add((Component) content);
    	add(new AppFooter());
    }
}
