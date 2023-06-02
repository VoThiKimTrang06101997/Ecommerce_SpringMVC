package com.trang.MobileShop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles_user.xml",  
				"/WEB-INF/tiles/tiles_admin.xml",
				"/WEB-INF/tiles/tiles_admin_category.xml",
				"/WEB-INF/tiles/tiles_admin_product.xml",
				"/WEB-INF/tiles/tiles_admin_photo.xml",
				"/WEB-INF/tiles/tiles_product.xml"});
		return configurer;
	}
}
