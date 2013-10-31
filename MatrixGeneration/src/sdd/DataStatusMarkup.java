//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.17 at 07:34:43 PM EDT 
//


package sdd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * Variant of DataStatusData to be used inside the NaturalLanguageDescription markup container.
 * 
 * <p>Java class for DataStatusMarkup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataStatusMarkup">
 *   &lt;complexContent>
 *     &lt;extension base="{http://rs.tdwg.org/UBIF/2006/}DataStatus">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Note" type="{http://rs.tdwg.org/UBIF/2006/}MarkupText"/>
 *         &lt;element name="Text" type="{http://rs.tdwg.org/UBIF/2006/}MarkupText"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataStatusMarkup", propOrder = {
    "noteOrText"
})
public class DataStatusMarkup
    extends DataStatus
{

    @XmlElementRefs({
        @XmlElementRef(name = "Note", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class),
        @XmlElementRef(name = "Text", namespace = "http://rs.tdwg.org/UBIF/2006/", type = JAXBElement.class)
    })
    protected List<JAXBElement<MarkupText>> noteOrText;

    /**
     * Gets the value of the noteOrText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noteOrText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoteOrText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MarkupText }{@code >}
     * {@link JAXBElement }{@code <}{@link MarkupText }{@code >}
     * 
     * 
     */
    public List<JAXBElement<MarkupText>> getNoteOrText() {
        if (noteOrText == null) {
            noteOrText = new ArrayList<JAXBElement<MarkupText>>();
        }
        return this.noteOrText;
    }

}
