//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.11 at 12:08:08 PM EDT 
//


package annotationSchema.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the annotationSchema.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.

 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SynonymOfSpeciesName_QNAME = new QName("", "synonym_of_species_name");
    private final static QName _Discussion_QNAME = new QName("", "discussion");
    private final static QName _GlobalDistribution_QNAME = new QName("", "global_distribution");
    private final static QName _SynonymOfTribeGenus_QNAME = new QName("", "synonym_of_tribe_genus");
    private final static QName _PlaceOfPublication_QNAME = new QName("", "place_of_publication");
    private final static QName _SubgenusName_QNAME = new QName("", "subgenus_name");
    private final static QName _Conserved_QNAME = new QName("", "conserved");
    private final static QName _CommonName_QNAME = new QName("", "common_name");
    private final static QName _SynonymOfSubspeciesName_QNAME = new QName("", "synonym_of_subspecies_name");
    private final static QName _TribeName_QNAME = new QName("", "tribe_name");
    private final static QName _SynonymOfVarietyName_QNAME = new QName("", "synonym_of_variety_name");
    private final static QName _NumberOfInfrataxa_QNAME = new QName("", "number_of_infrataxa");
    private final static QName _Authority_QNAME = new QName("", "authority");
    private final static QName _SynonymOfGenusName_QNAME = new QName("", "synonym_of_genus_name");
    private final static QName _References_QNAME = new QName("", "references");
    private final static QName _CaDistribution_QNAME = new QName("", "ca_distribution");
    private final static QName _SynonymOfFamily_QNAME = new QName("", "synonym_of_family");
    private final static QName _SynonymOfTribeName_QNAME = new QName("", "synonym_of_tribe_name");
    private final static QName _Conservation_QNAME = new QName("", "conservation");
    private final static QName _SpeciesName_QNAME = new QName("", "species_name");
    private final static QName _GenusName_QNAME = new QName("", "genus_name");
    private final static QName _FamilyName_QNAME = new QName("", "family_name");
    private final static QName _AuthorOfTribeGenus_QNAME = new QName("", "author_of_tribe_genus");
    private final static QName _Key_QNAME = new QName("", "key");
    private final static QName _SubspeciesName_QNAME = new QName("", "subspecies_name");
    private final static QName _Text_QNAME = new QName("", "text");
    private final static QName _FloweringTime_QNAME = new QName("", "flowering_time");
    private final static QName _VarietyName_QNAME = new QName("", "variety_name");
    private final static QName _Elevation_QNAME = new QName("", "elevation");
    private final static QName _Couplet_QNAME = new QName("", "couplet");
    private final static QName _Number_QNAME = new QName("", "number");
    private final static QName _Habitat_QNAME = new QName("", "habitat");
    private final static QName _PastName_QNAME = new QName("", "past_name");
    private final static QName _Derivation_QNAME = new QName("", "derivation");
    private final static QName _UsDistribution_QNAME = new QName("", "us_distribution");
    private final static QName _RunInSidehead_QNAME = new QName("", "run_in_sidehead");
    private final static QName _AuthorOfFamily_QNAME = new QName("", "author_of_family");
    private final static QName _Introduced_QNAME = new QName("", "introduced");
    private final static QName _GeneralDistribution_QNAME = new QName("", "general_distribution");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: annotationSchema.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Statement }
     * 
     */
    public Statement createStatement() {
        return new Statement();
    }

    /**
     * Create an instance of {@link Character }
     * 
     */
    public Character createCharacter() {
        return new Character();
    }

    /**
     * Create an instance of {@link Relation }
     * 
     */
    public Relation createRelation() {
        return new Relation();
    }

    /**
     * Create an instance of {@link Treatment }
     * 
     */
    public Treatment createTreatment() {
        return new Treatment();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }

    /**
     * Create an instance of {@link Structure }
     * 
     */
    public Structure createStructure() {
        return new Structure();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "synonym_of_species_name")
    public JAXBElement<String> createSynonymOfSpeciesName(String value) {
        return new JAXBElement<String>(_SynonymOfSpeciesName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "discussion")
    public JAXBElement<String> createDiscussion(String value) {
        return new JAXBElement<String>(_Discussion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "global_distribution")
    public JAXBElement<String> createGlobalDistribution(String value) {
        return new JAXBElement<String>(_GlobalDistribution_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "synonym_of_tribe_genus")
    public JAXBElement<String> createSynonymOfTribeGenus(String value) {
        return new JAXBElement<String>(_SynonymOfTribeGenus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "place_of_publication")
    public JAXBElement<String> createPlaceOfPublication(String value) {
        return new JAXBElement<String>(_PlaceOfPublication_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subgenus_name")
    public JAXBElement<String> createSubgenusName(String value) {
        return new JAXBElement<String>(_SubgenusName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "conserved")
    public JAXBElement<String> createConserved(String value) {
        return new JAXBElement<String>(_Conserved_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "common_name")
    public JAXBElement<String> createCommonName(String value) {
        return new JAXBElement<String>(_CommonName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "synonym_of_subspecies_name")
    public JAXBElement<String> createSynonymOfSubspeciesName(String value) {
        return new JAXBElement<String>(_SynonymOfSubspeciesName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tribe_name")
    public JAXBElement<String> createTribeName(String value) {
        return new JAXBElement<String>(_TribeName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "synonym_of_variety_name")
    public JAXBElement<String> createSynonymOfVarietyName(String value) {
        return new JAXBElement<String>(_SynonymOfVarietyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "number_of_infrataxa")
    public JAXBElement<String> createNumberOfInfrataxa(String value) {
        return new JAXBElement<String>(_NumberOfInfrataxa_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "authority")
    public JAXBElement<String> createAuthority(String value) {
        return new JAXBElement<String>(_Authority_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "synonym_of_genus_name")
    public JAXBElement<String> createSynonymOfGenusName(String value) {
        return new JAXBElement<String>(_SynonymOfGenusName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "references")
    public JAXBElement<String> createReferences(String value) {
        return new JAXBElement<String>(_References_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ca_distribution")
    public JAXBElement<String> createCaDistribution(String value) {
        return new JAXBElement<String>(_CaDistribution_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "synonym_of_family")
    public JAXBElement<String> createSynonymOfFamily(String value) {
        return new JAXBElement<String>(_SynonymOfFamily_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "synonym_of_tribe_name")
    public JAXBElement<String> createSynonymOfTribeName(String value) {
        return new JAXBElement<String>(_SynonymOfTribeName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "conservation")
    public JAXBElement<String> createConservation(String value) {
        return new JAXBElement<String>(_Conservation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "species_name")
    public JAXBElement<String> createSpeciesName(String value) {
        return new JAXBElement<String>(_SpeciesName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "genus_name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createGenusName(String value) {
        return new JAXBElement<String>(_GenusName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "family_name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createFamilyName(String value) {
        return new JAXBElement<String>(_FamilyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "author_of_tribe_genus")
    public JAXBElement<String> createAuthorOfTribeGenus(String value) {
        return new JAXBElement<String>(_AuthorOfTribeGenus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "key")
    public JAXBElement<String> createKey(String value) {
        return new JAXBElement<String>(_Key_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "subspecies_name")
    public JAXBElement<String> createSubspeciesName(String value) {
        return new JAXBElement<String>(_SubspeciesName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "text")
    public JAXBElement<String> createText(String value) {
        return new JAXBElement<String>(_Text_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "flowering_time")
    public JAXBElement<String> createFloweringTime(String value) {
        return new JAXBElement<String>(_FloweringTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "variety_name")
    public JAXBElement<String> createVarietyName(String value) {
        return new JAXBElement<String>(_VarietyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "elevation")
    public JAXBElement<String> createElevation(String value) {
        return new JAXBElement<String>(_Elevation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "couplet")
    public JAXBElement<String> createCouplet(String value) {
        return new JAXBElement<String>(_Couplet_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "number")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createNumber(String value) {
        return new JAXBElement<String>(_Number_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "habitat")
    public JAXBElement<String> createHabitat(String value) {
        return new JAXBElement<String>(_Habitat_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "past_name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    public JAXBElement<String> createPastName(String value) {
        return new JAXBElement<String>(_PastName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "derivation")
    public JAXBElement<String> createDerivation(String value) {
        return new JAXBElement<String>(_Derivation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "us_distribution")
    public JAXBElement<String> createUsDistribution(String value) {
        return new JAXBElement<String>(_UsDistribution_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "run_in_sidehead")
    public JAXBElement<String> createRunInSidehead(String value) {
        return new JAXBElement<String>(_RunInSidehead_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "author_of_family")
    public JAXBElement<String> createAuthorOfFamily(String value) {
        return new JAXBElement<String>(_AuthorOfFamily_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "introduced")
    public JAXBElement<String> createIntroduced(String value) {
        return new JAXBElement<String>(_Introduced_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "general_distribution")
    public JAXBElement<String> createGeneralDistribution(String value) {
        return new JAXBElement<String>(_GeneralDistribution_QNAME, String.class, null, value);
    }

}
