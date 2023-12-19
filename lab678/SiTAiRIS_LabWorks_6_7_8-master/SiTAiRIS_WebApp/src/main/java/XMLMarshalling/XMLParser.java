package XMLMarshalling;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
    private File XMLFile;

    public XMLParser(String path) {
        this.XMLFile = new File(path);
    }

    public Document buildDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringComments(true);
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(XMLFile);
    }
}
