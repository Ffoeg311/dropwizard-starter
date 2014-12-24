package com.ghporter.application;



import com.ghporter.configuration.AppConfiguration;
import com.ghporter.controller.HomePage;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class AppApplication extends Application<AppConfiguration> {

	public static void main(String[] args) throws Exception {		
		new AppApplication().run(args);		
	}

	// Responsible for adding assets to pipeline
	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		bootstrap.addBundle(new ViewBundle());
		bootstrap
				.addBundle(new AssetsBundle("/assets/css", "/css", null, "css"));
		bootstrap.addBundle(new AssetsBundle("/assets/js", "/js", null, "js"));
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment)
			throws Exception {	
		// register datasource
		/*final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment,
                configuration.getDataSourceFactory(), "mysql");*/
		// Register the home page with the environment
		final HomePage homePage = new HomePage();
		environment.jersey().register(homePage);
	}

}
