/**
 *
 */
package generateFileToTaxonMap;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

/**
 * @author Hong Updates The input is a FNA volume marked for JSTOR
 */
public class FileName2TaxonLoaderFNA extends FileName2TaxonLoader {

    static String domainstr = "";
    static String kingdomstr = "";
    static String phylumstr = "";
    static String subphylumstr = "";
    static String superdivisionstr = "";
    static String divisionstr = "";
    static String superclassstr = "";
    static String classstr = "";
    static String subclassstr = "";
    static String superorderstr = "";
    static String orderstr = "";
    static String suborderstr = "";
    static String superfamilystr = "";
    static String familystr = "";
    static String subfamilystr = "";
    static String tribestr = "";
    static String subtribestr = "";
    static String genusstr = "";
    static String subgenusstr = "";
    static String sectionstr = "";
    static String subsectionstr = "";
    static String speciesstr = "";
    static String subspeciesstr = "";
    static String varietystr = "";
    static XPath familypath;
    static XPath subfamilypath;
    static XPath tribepath;
    static XPath subtribepath;
    static XPath genuspath;
    static XPath subgenuspath;
    static XPath sectionpath;
    static XPath subsectionpath;
    static XPath speciespath;
    static XPath subspeciespath;
    static XPath varietypath;
    static XPath descriptionpath;

    static {
        try {
            familypath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/family_name");
            subfamilypath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/subfamily_name");
            tribepath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/tribe_name");
            subtribepath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/subtribe_name");
            genuspath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/genus_name");
            subgenuspath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/subgenus_name");
            sectionpath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/section_name");
            subsectionpath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/subsection_name");
            speciespath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/species_name");
            subspeciespath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/subspecies_name");
            varietypath = XPath.newInstance("//TaxonIdentification[@Status='ACCEPTED']/variety_name");
            descriptionpath = XPath.newInstance("//description");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            LOGGER.error(sw.toString());
        }
    }
    
   /*static {
        try {
            familypath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/family_name");
            subfamilypath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/subfamily_name");
            tribepath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/tribe_name");
            subtribepath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/subtribe_name");
            genuspath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/genus_name");
            subgenuspath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/subgenus_name");
            sectionpath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/section_name");
            subsectionpath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/subsection_name");
            speciespath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/species_name");
            subspeciespath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/subspecies_name");
            varietypath = XPath.newInstance("//taxon_identification[@status='ACCEPTED']/variety_name");
            descriptionpath = XPath.newInstance("//description");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            LOGGER.error(sw.toString());
        }
    }*/

    /**
     *
     */
    public FileName2TaxonLoaderFNA(String inputfilepath) throws Exception {
        super(inputfilepath);
    }

    @Override
    /**
     * use XPath to extract values from XML file need filename, hasdescription,
     * family, etc.
     */
    protected void populateFilename2TaxonTableUsing(File xml) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(xml);
            Element root = doc.getRootElement();
            if (descriptionpath.selectNodes(root).size() > 0) {
                values.put("hasdescription", "1");
            } else {
                values.put("hasdescription", "0");
            }
            values.put("filename", xml.getName());

            values.put("domain", domainstr);
            values.put("kingdom", kingdomstr);
            values.put("phylum", phylumstr);
            values.put("subphylum", subphylumstr);
            values.put("superdivision", superdivisionstr);
            values.put("division", divisionstr);
            values.put("superclass", superclassstr);
            values.put("class", classstr);
            values.put("subclass", subclassstr);
            values.put("superorder", superorderstr);
            values.put("order", orderstr);
            values.put("suborder", suborderstr);
            values.put("superfamily", superfamilystr);

            Element family = (Element) familypath.selectSingleNode(root);
            if (family != null) {
                familystr = family.getTextNormalize().toLowerCase();
                subfamilystr = "";
                tribestr = "";
                subtribestr = "";
                genusstr = "";
                subgenusstr = "";
                sectionstr = "";
                subsectionstr = "";
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("family", familystr);

            Element subfamily = (Element) subfamilypath.selectSingleNode(root);
            if (subfamily != null) {
                subfamilystr = subfamily.getTextNormalize().toLowerCase();
                tribestr = "";
                subtribestr = "";
                genusstr = "";
                subgenusstr = "";
                sectionstr = "";
                subsectionstr = "";
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("subfamily", subfamilystr);
            Element tribe = (Element) tribepath.selectSingleNode(root);
            if (tribe != null) {
                tribestr = tribe.getTextNormalize().toLowerCase();
                subtribestr = "";
                genusstr = "";
                subgenusstr = "";
                sectionstr = "";
                subsectionstr = "";
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("tribe", tribestr);
            Element subtribe = (Element) subtribepath.selectSingleNode(root);
            if (subtribe != null) {
                subtribestr = subtribe.getTextNormalize().toLowerCase();
                genusstr = "";
                subgenusstr = "";
                sectionstr = "";
                subsectionstr = "";
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("subtribe", subtribestr);
            Element genus = (Element) genuspath.selectSingleNode(root);
            if (genus != null) {
                genusstr = genus.getTextNormalize().toLowerCase();
                subgenusstr = "";
                sectionstr = "";
                subsectionstr = "";
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("genus", genusstr);
            Element subgenus = (Element) subgenuspath.selectSingleNode(root);
            if (subgenus != null) {
                subgenusstr = subgenus.getTextNormalize().toLowerCase();
                sectionstr = "";
                subsectionstr = "";
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("subgenus", subgenusstr);
            Element section = (Element) sectionpath.selectSingleNode(root);
            if (section != null) {
                sectionstr = section.getTextNormalize().toLowerCase();
                subsectionstr = "";
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("section", sectionstr);
            Element subsection = (Element) subsectionpath.selectSingleNode(root);
            if (subsection != null) {
                subsectionstr = subsection.getTextNormalize().toLowerCase();
                speciesstr = "";
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("subsection", subsectionstr);
            Element species = (Element) speciespath.selectSingleNode(root);
            if (species != null) {
                speciesstr = species.getTextNormalize().toLowerCase();
                subspeciesstr = "";
                varietystr = "";
            }
            values.put("species", speciesstr);
            Element subspecies = (Element) subspeciespath.selectSingleNode(root);
            if (subspecies != null) {
                subspeciesstr = subspecies.getTextNormalize().toLowerCase();
                varietystr = "";
            }
            values.put("subspecies", subspeciesstr);
            Element variety = (Element) varietypath.selectSingleNode(root);
            if (variety != null) {
                varietystr = variety.getTextNormalize().toLowerCase();
            }
            values.put("variety", varietystr);
            addToList();
            resetValues();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            //	LOGGER.error(ApplicationUtilities.getProperty("CharaParser.version")+System.getProperty("line.separator")+sw.toString());
        }
    }

    /**
     * @param args
     */
 /*   public static void main(String[] args) {
        String filepath = "C:\\Users\\jingliu5\\UFLwork\\Charaparser\\FoC\\FoCV10\\target\\final\\";
        FileName2TaxonLoaderFNA fntf = new FileName2TaxonLoaderFNA(filepath);
        fntf.populateFilename2TaxonTable();
    }*/
}
