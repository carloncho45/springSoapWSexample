package com.springexample.www.config;

import java.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@ComponentScan({"com.springexample.www"}) 
public class AppConfig extends WsConfigurerAdapter {

	@Bean(name = "students")
	public DefaultWsdl11Definition ws_students(XsdSchema studentsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("getStudentRequest");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://com.springexample.www/soap");
		wsdl11Definition.setSchema(studentsSchema);
		return wsdl11Definition;
	}
	@Bean
	public XsdSchema studentsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("students.xsd"));
	}
	
	@Bean(name = "suma")
	public DefaultWsdl11Definition ws_suma(XsdSchema sumaSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("sumaRequest");
		wsdl11Definition.setLocationUri("/soapws");
		wsdl11Definition.setTargetNamespace("http://com.springexample.www/soap");
		wsdl11Definition.setSchema(sumaSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema sumaSchema() {
		return new SimpleXsdSchema(new ClassPathResource("suma.xsd"));
	}
	
	@Bean
	public SaajSoapMessageFactory messageFactory(){
		SaajSoapMessageFactory messageFactory =new SaajSoapMessageFactory();
		messageFactory.setSoapVersion(SoapVersion.SOAP_11);
		return messageFactory;
	}
	
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
		validatingInterceptor.setXsdSchema(sumaSchema());
	    validatingInterceptor.setValidateRequest(true);
		validatingInterceptor.setValidateResponse(true);
		interceptors.add(validatingInterceptor);
		interceptors.add(new PayloadLoggingInterceptor());
	}
	
//	 @Override
//     public void addInterceptors(List<EndpointInterceptor> interceptors) {
//         PayloadLoggingInterceptor payloadLoggingInterceptor = new PayloadLoggingInterceptor();
//         interceptors.add(payloadLoggingInterceptor);
//     }
	 
//
//	 @Bean
//		public SaajSoapMessageFactory messageFactory() {
//		    SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
//		    messageFactory.setSoapVersion(SoapVersion.SOAP_12);
//		    return messageFactory;
//		}

	
}
