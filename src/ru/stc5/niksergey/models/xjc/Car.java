//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.17 at 03:09:03 PM MSK 
//


package ru.stc5.niksergey.models.xjc;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Car complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Car">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carModel" type="{}CarModel"/>
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
@XmlType(name = "Car", propOrder = {
    "carModel",
    "vin",
    "year",
        "id"
})
@XmlRootElement
public class Car {

    @XmlElement(required = true)
    protected CarModel carModel;
    @XmlElement(required = true)
    protected String vin;
    @XmlElement(required = true)
    protected int year;
    @XmlElement(required = true)
    protected int id;

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link CarModel }
     *     
     */
    public CarModel getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarModel }
     *     
     */
    public void setCarModel(CarModel value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the vin property.
     * 
     */
    public String getVin() {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     */
    public void setVin(String value) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel=" + carModel +
                ", vin='" + vin + '\'' +
                ", year=" + year +
                '}';
    }
}
