package XMLMarshalling;

import Entities.Administration;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;

public class AdministrationList {
    public static List<Administration> getAdministrationList(String path) {
        List<Administration> adms = new ArrayList<>();

        XMLParser xmlParser = new XMLParser(path);
        Document doc;
        try {
            doc = xmlParser.buildDocument();
        } catch (Exception e) {
            System.out.println("Parsing error: " + e);
            return null;
        }

        Node rootNode = doc.getFirstChild();
        NodeList rootChildren = rootNode.getChildNodes();

        Node administrationNode = null;
        for (int i = 1; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;

            if (rootChildren.item(i).getNodeName().equals("administration")) {
                administrationNode = rootChildren.item(i);
            }
        }
        NodeList administrationChildren = administrationNode.getChildNodes();

        for (int i = 0; i < administrationChildren.getLength(); i++) {
            if (administrationChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if (!administrationChildren.item(i).getNodeName().equals("administrator")) continue;

            String passNumber = null, post = null, fullName = null;
            int age = 0, stage = 0;

            passNumber = administrationChildren.item(i).getAttributes().getNamedItem("passNumber").getNodeValue();
            NodeList adminChildren = administrationChildren.item(i).getChildNodes();
            for (int j = 0; j < adminChildren.getLength(); j++) {
                if (adminChildren.item(j).getNodeType() != Node.ELEMENT_NODE) continue;
                switch (adminChildren.item(j).getNodeName()) {
                    case "post": post = adminChildren.item(j).getTextContent(); break;
                    case "fullName": fullName = adminChildren.item(j).getTextContent(); break;
                    case "age": age = Integer.parseInt(adminChildren.item(j).getTextContent()); break;
                    case "stage": stage = Integer.parseInt(adminChildren.item(j).getTextContent()); break;
                }
            }

            Administration admin = new Administration(
                    passNumber,
                    post,
                    fullName,
                    age,
                    stage
            );

            adms.add(admin);
        }

        return adms;
    }
}
