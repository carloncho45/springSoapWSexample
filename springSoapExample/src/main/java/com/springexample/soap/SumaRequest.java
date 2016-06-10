//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.06.10 a las 03:30:10 PM COT 
//


package com.springexample.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="N1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="N2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "n1",
    "n2"
})
@XmlRootElement(name = "sumaRequest")
public class SumaRequest {

    @XmlElement(name = "N1")
    protected int n1;
    @XmlElement(name = "N2")
    protected int n2;

    /**
     * Obtiene el valor de la propiedad n1.
     * 
     */
    public int getN1() {
        return n1;
    }

    /**
     * Define el valor de la propiedad n1.
     * 
     */
    public void setN1(int value) {
        this.n1 = value;
    }

    /**
     * Obtiene el valor de la propiedad n2.
     * 
     */
    public int getN2() {
        return n2;
    }

    /**
     * Define el valor de la propiedad n2.
     * 
     */
    public void setN2(int value) {
        this.n2 = value;
    }

}
