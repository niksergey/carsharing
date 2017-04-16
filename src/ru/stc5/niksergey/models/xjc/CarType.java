//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.16 at 02:03:33 PM MSK 
//


package ru.stc5.niksergey.models.xjc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for carType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carModel" type="{}CarModelType"/>
 *         &lt;element name="vin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="year">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="2000"/>
 *               &lt;maxInclusive value="2020"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carType", propOrder = {
    "carModel",
    "vin",
    "year"
})
public class CarType {

    @XmlElement(required = true)
    protected CarModelType carModel;
    protected int vin;
    protected int year;

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link CarModelType }
     *     
     */
    public CarModelType getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarModelType }
     *     
     */
    public void setCarModel(CarModelType value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the vin property.
     * 
     */
    public int getVin() {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     */
    public void setVin(int value) {
        this.vin = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

    @Override
    public String toString() {
        return "CarType{" +
                "carModel=" + carModel +
                ", vin=" + vin +
                ", year=" + year +
                '}';
    }
}