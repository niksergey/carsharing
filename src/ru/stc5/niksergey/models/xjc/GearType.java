//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.16 at 02:05:45 PM MSK 
//


package ru.stc5.niksergey.models.xjc;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gearType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="gearType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="automatic"/>
 *     &lt;enumeration value="manual"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "gearType")
@XmlEnum
public enum GearType {

    @XmlEnumValue("automatic")
    AUTOMATIC("automatic"),
    @XmlEnumValue("manual")
    MANUAL("manual");
    private final String value;

    GearType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GearType fromValue(String v) {
        for (GearType c: GearType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}