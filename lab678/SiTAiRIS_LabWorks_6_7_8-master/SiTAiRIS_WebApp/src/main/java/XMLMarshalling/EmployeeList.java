package XMLMarshalling;

import Entities.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    public static List<Employee> getEmployeeList(String path) {
        List<Employee> emps = new ArrayList<>();

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

        Node employeeNode = null;
        for (int i = 1; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;

            if (rootChildren.item(i).getNodeName().equals("employees")) {
                employeeNode = rootChildren.item(i);
            }
        }
        NodeList employeeChildren = employeeNode.getChildNodes();

        for (int i = 0; i < employeeChildren.getLength(); i++) {
            if (employeeChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if (!employeeChildren.item(i).getNodeName().equals("employee")) continue;

            String passNumber = null, fullName = null;
            int hours = 0, salary = 0;

            passNumber = employeeChildren.item(i).getAttributes().getNamedItem("passNumber").getNodeValue();
            NodeList empChildren = employeeChildren.item(i).getChildNodes();
            for (int j = 0; j < empChildren.getLength(); j++) {
                if (empChildren.item(j).getNodeType() != Node.ELEMENT_NODE) continue;
                switch (empChildren.item(j).getNodeName()) {
                    case "fullName": fullName = empChildren.item(j).getTextContent(); break;
                    case "hours": hours = Integer.parseInt(empChildren.item(j).getTextContent()); break;
                    case "salary": salary = Integer.parseInt(empChildren.item(j).getTextContent()); break;
                }
            }

            Employee employee = new Employee(
                    passNumber,
                    fullName,
                    hours,
                    salary
            );

            emps.add(employee);
        }

        return emps;
    }
}
