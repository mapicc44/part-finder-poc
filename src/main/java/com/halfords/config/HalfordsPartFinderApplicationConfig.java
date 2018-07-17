package com.halfords.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.handler.Handler;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.halfords.partfinder.utils.JaxWsHandlerResolver;
import com.halfords.partfinder.utils.ServiceLogHandler;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = { "com.halfords" })
@PropertySources({ 
	@PropertySource(value = { "classpath:application.properties" }),
	@PropertySource(value = { "file:${catalina.base}/conf/application.properties" },
	ignoreResourceNotFound = true) 
})
public class HalfordsPartFinderApplicationConfig {

    @Value("${partfinder.application.version}")
    private String version;
    
    @Value("${server.servlet.contextPath}")
    private String contextPath;
    
////////////////////////

    @Value("${store6.url}")
    private String store6Url;
    
    @Value("${store6.username}")
    private String store6Username;
    
    @Value("${store6.password}")
    private String store6Password;
    
////////////////////////
    
//    @Value("${st.url}")
//    private String stUrl;
//    
//    @Value("${st.username}")
//    private String stUsername;
//    
//    @Value("${st.password}")
//    private String stPassword;
//    
//    @Value("${st.timeout}")
//    private String stTimeout;
//    
//    @Value("${st.maxtimeout}")
//    private String stMaxTimeout;
    
////////////////////////
    
//	@Value("${rtr.url}")
//	private String rtrUrl;
//	
//	@Value("${rtr.username}")
//	private String rtrUsername;
//	
//	@Value("${rtr.password}")
//	private String rtrPassword;

////////////////////////
    
    @Value("${ordextr.url}")
    private String ordextrUrl;
    
    @Value("${ordextr.username}")
    private String ordextrUsername;
    
    @Value("${ordextr.password}")
    private String ordextrPassword;
    
////////////////////////////////////////////////////////////////////
	
    @Bean
    Jaxb2Marshaller jaxb2MarshallerStore6() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.halfords.connectors.sap.store6");
        jaxb2Marshaller.setMarshallerProperties(props);
        
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplateStore6() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2MarshallerStore6());
        webServiceTemplate.setUnmarshaller(jaxb2MarshallerStore6());
        webServiceTemplate.setDefaultUri(store6Url);
        webServiceTemplate.setMessageSender(messageSenderStore6());
        return webServiceTemplate;
    }
    
	@Bean
	public HttpComponentsMessageSender messageSenderStore6() {
	    HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
	    messageSender.setCredentials(new UsernamePasswordCredentials(store6Username, store6Password));
	    return messageSender;
	}
	
	@Bean
	public com.halfords.connectors.sap.store6.ObjectFactory objectFactoryStore6() {
		com.halfords.connectors.sap.store6.ObjectFactory objectFactory = new com.halfords.connectors.sap.store6.ObjectFactory();
	    return objectFactory;
	}
    
////////////////////////////////////////////////////////////////////

//    @Bean
//    Jaxb2Marshaller jaxb2MarshallerRtr() {
//        Map<String, Object> props = new HashMap<String, Object>();
//        props.put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        
//        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//        jaxb2Marshaller.setContextPath("com.halfords.xi.out.ecommerce.rtr");
//        jaxb2Marshaller.setMarshallerProperties(props);
//        
//        return jaxb2Marshaller;
//    }
//
//    @Bean
//    public WebServiceTemplate webServiceTemplateRtr() {
//        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
//        webServiceTemplate.setMarshaller(jaxb2MarshallerRtr());
//        webServiceTemplate.setUnmarshaller(jaxb2MarshallerRtr());
//        webServiceTemplate.setDefaultUri(rtrUrl);
//        webServiceTemplate.setMessageSender(messageSenderRtr());
//        return webServiceTemplate;
//    }
//
//	@Bean
//	public HttpComponentsMessageSender messageSenderRtr() {
//	    HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
//	    messageSender.setCredentials(new UsernamePasswordCredentials(rtrUsername, rtrPassword));
//	    return messageSender;
//	}
	
	@Bean
	public com.halfords.xi.out.ecommerce.rtr.ObjectFactory objectFactoryRtr() {
		com.halfords.xi.out.ecommerce.rtr.ObjectFactory objectFactory = new com.halfords.xi.out.ecommerce.rtr.ObjectFactory();
	    return objectFactory;
	}

////////////////////////////////////////////////////////////////////
	
    @Bean
    Jaxb2Marshaller jaxb2MarshallerOrdextr() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.halfords.xi.out.ecommerce.co");
        jaxb2Marshaller.setMarshallerProperties(props);
        
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplateOrdextr() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2MarshallerOrdextr());
        webServiceTemplate.setUnmarshaller(jaxb2MarshallerOrdextr());
        webServiceTemplate.setDefaultUri(ordextrUrl);
        webServiceTemplate.setMessageSender(messageSenderOrdextr());
        return webServiceTemplate;
    }
    
	@Bean
	public HttpComponentsMessageSender messageSenderOrdextr() {
	    HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
	    messageSender.setCredentials(new UsernamePasswordCredentials(ordextrUsername, ordextrPassword));
	    return messageSender;
	}
	
	@Bean
	public com.halfords.xi.out.ecommerce.co.ObjectFactory objectFactoryOrdextr() {
		com.halfords.xi.out.ecommerce.co.ObjectFactory objectFactory = new com.halfords.xi.out.ecommerce.co.ObjectFactory();
	    return objectFactory;
	}


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.halfords.partfinder.controller")) // .apis(RequestHandlerSelectors.any())
				.paths(regex("/.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		final ApiInfo apiInfo = new ApiInfo(
				"Part Finder POC REST API","API used by the Part Finder POC application", 
				version, "", ApiInfo.DEFAULT_CONTACT, "", "", new ArrayList<VendorExtension>());
		return apiInfo;
	}
}