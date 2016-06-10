package com.springexample.www.config;


import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.Namespace;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;

import com.springexample.soap.ListaNumeros;
import com.springexample.soap.ListaRequest;
import com.springexample.soap.ListaResponse;
import com.springexample.soap.MultiplicacionRequest;
import com.springexample.soap.MultiplicacionResponse;
import com.springexample.soap.SumaRequest;
import com.springexample.soap.SumaResponse;

@Endpoint
public class SumaEndpoint {
	private static final String NAMESPACE_URI = "http://springexample.com/soap";
	 static Logger logger = Logger.getLogger("SumaEndpoint");
	
//	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sumaRequest")
//	@ResponsePayload
//	public SumaResponse getSuma(@RequestPayload SumaRequest request) {
//		logger.info(request.getN1()+"****"+request.getN2());
//		SumaResponse response = new SumaResponse();
//		response.setResultado(request.getN1()+request.getN2());
//		//response.setStudent(studentUtility.getStudent(request.getStudentId()));
//		return response;
//	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "multiplicacionRequest")
	@ResponsePayload
	public MultiplicacionResponse getMultiplicacion(@RequestPayload MultiplicacionRequest request) {
		  MultiplicacionResponse response = new MultiplicacionResponse();
		  response.setResultado(request.getN1()*request.getN2());
		//response.setStudent(studentUtility.getStudent(request.getStudentId()));
		return response;
	}
	
	  @PayloadRoot(localPart = "sumaRequest", namespace = NAMESPACE_URI)
	  @Namespace(prefix="rn",uri=NAMESPACE_URI)
	  @ResponsePayload
	  public SumaResponse getSuma(/*@XPathParam("/rn:sumaRequest/rn")*/ 
			  @RequestPayload SumaRequest request) {
		  logger.info(request.getN1()+"****"+request.getN2());
		  logger.debug(request.getN1()+"****"+request.getN2());
		  SumaResponse sumar =new SumaResponse();
		 sumar.setResultado(request.getN1()+request.getN2());
		  //sumar.setResultado(10);
	    // create Source from order and return it
		  return sumar;
	  	}
	  
	  
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "listaRequest")
	@ResponsePayload
	public ListaResponse getListaNumeros(@RequestPayload ListaRequest request) {
		  ListaResponse response = new ListaResponse();
		  ListaNumeros lista=new ListaNumeros();
		  ListaNumeros.Campos row=null;
		  for(int i=0; i<request.getCantidad();i++){
			  row=new ListaNumeros.Campos();
			  row.setId(i);
			  row.setValor(i*100);
			  lista.getCampos().add(row);
		  }
		 response.setResultado(lista);
		  //response.setResultado(request.getN1()*request.getN2());
		//response.setStudent(studentUtility.getStudent(request.getStudentId()));
		return response;
	}
}
