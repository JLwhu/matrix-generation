//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.17 at 07:34:43 PM EDT 
//


package sdd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Required lower and upper attributes in the range 0-1. Used, e. g., for probabilities or values commonly expressed as percent
 * 
 * <p>Java class for ZeroToOneRange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZeroToOneRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://rs.tdwg.org/UBIF/2006/}ValueRangeOrVerbatim">
 *       &lt;attribute name="lower" use="required" type="{http://rs.tdwg.org/UBIF/2006/}ZeroToOne" />
 *       &lt;attribute name="upper" use="required" type="{http://rs.tdwg.org/UBIF/2006/}ZeroToOne" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZeroToOneRange")
public class ZeroToOneRange
    extends ValueRangeOrVerbatim
{


}
