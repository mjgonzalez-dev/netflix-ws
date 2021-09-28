package com.everis.d4i.tutorial.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.everis.d4i.tutorial.utils.constants.RestConstants;
import com.everis.d4i.tutorial.utils.constants.SwaggerConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is used to enable swagger configuration.<br/>
 * Swagger is used for REST API documentation<br/>
 * Use swagger-ui.html to access the api doc<br/>
 * Example : http://localhost:server.port/swagger-ui.html<br/>
 * 
 * http://localhost:8088/netflix/v1/swagger-ui.html
 * 
 * <br/>
 * <br/>
 *
 * How to generate document ? <br/>
 * Step 1: get JSON from api-docs by giving the group-name (example
 * http://localhost:server.port/v2/api-docs?group=CustomerServices ) <br/>
 * Step 2: goto http://editor.swagger.io/ : its an editor which is online and do
 * paste JSON and generate document<br/>
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(SwaggerConstants.NETFLIX)
				.apiInfo(apiInfo()).select()
				.paths(regex(".*" + RestConstants.APPLICATION_NAME + "/.*"))
				.build()
	             .tags(new Tag(SwaggerConstants.TAG_CATEGORIES, SwaggerConstants.DESCRIPTION_CATEGORIES, 1),
	            	   new Tag(SwaggerConstants.TAG_TV_SHOW, SwaggerConstants.DESCRIPTION_TV_SHOW ,2),
	                   new Tag(SwaggerConstants.TAG_SEASONS, SwaggerConstants.DESCRIPTION_SEASONS, 3),
	                   new Tag(SwaggerConstants.TAG_CHAPTERS, SwaggerConstants.DESCRIPTION_CHAPTERS, 4));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(SwaggerConstants.NETFLIX)
				.description("TVShow Api")
				.termsOfServiceUrl("https://www.everis.com")
				.license("everis")
				.licenseUrl("https://www.everis.com")
				.version("1.0")
				.build();
	}

	
}
