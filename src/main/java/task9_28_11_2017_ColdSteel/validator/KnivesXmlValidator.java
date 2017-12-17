package task9_28_11_2017_ColdSteel.validator;
import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class KnivesXmlValidator {

    public String validate(String xsdSchema, String xmlFile) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdSchema));
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(xmlFile)));

        } catch (Exception e) {
            return ("File " + xmlFile + " is not valid!\n" + e.getMessage());

        }
        return ("File " + xmlFile + " is valid!");
    }
}