import Entities.Enterprise;
import org.junit.jupiter.api.*;
import XMLMarshalling.*;
import org.w3c.dom.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    public final String XML_FILE = "D:\\SiTAiRIS_WebApp\\src\\main\\resources\\Enterprise.xml";
    public XMLParser xmlParser = null;
    public Document doc;

    @BeforeEach
    @Test
    public void xmlParsingTest() {
        String path = "D:\\SiTAiRIS_WebApp\\src\\main\\resources\\Enterprise.xml";
        assertSame(XML_FILE, path);
        xmlParser = new XMLParser(path);
        assertNotNull(path);
        try {
            doc = xmlParser.buildDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAdministrationListTest() {
        Node rootNode = doc.getFirstChild();
        NodeList rootChildren = rootNode.getChildNodes();

        Node administrationNode = null;
        for (int i = 1; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;

            if (rootChildren.item(i).getNodeName().equals("administration")) {
                administrationNode = rootChildren.item(i);
            }
        }

        assertNotNull(administrationNode);
        NodeList administrationChildren = administrationNode.getChildNodes();
        assertNotEquals(0, administrationChildren.getLength());

        for (int i = 0; i < administrationChildren.getLength(); i++) {
            if (administrationChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if (!administrationChildren.item(i).getNodeName().equals("administrator")) continue;

            String passNumber = null, post = null, fullName = null;
            int age = 0, stage = 0;

            passNumber = administrationChildren.item(i).getAttributes().getNamedItem("passNumber").getNodeValue();
            NodeList adminChildren = administrationChildren.item(i).getChildNodes();

            assertNotEquals(0, adminChildren.getLength());
            for (int j = 0; j < adminChildren.getLength(); j++) {
                if (adminChildren.item(j).getNodeType() != Node.ELEMENT_NODE) continue;
                switch (adminChildren.item(j).getNodeName()) {
                    case "post": post = adminChildren.item(j).getTextContent(); break;
                    case "fullName": fullName = adminChildren.item(j).getTextContent(); break;
                    case "age": age = Integer.parseInt(adminChildren.item(j).getTextContent()); break;
                    case "stage": stage = Integer.parseInt(adminChildren.item(j).getTextContent()); break;
                }
            }

            assertNotNull(passNumber);
            assertNotNull(post);
            assertNotNull(fullName);
            assertNotEquals(0, age);
            assertNotEquals(0, stage);
        }
    }

    @Test
    public void getEmployeeListTest() {
        Node rootNode = doc.getFirstChild();
        NodeList rootChildren = rootNode.getChildNodes();

        Node employeeNode = null;
        for (int i = 1; i < rootChildren.getLength(); i++) {
            if (rootChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;

            if (rootChildren.item(i).getNodeName().equals("employees")) {
                employeeNode = rootChildren.item(i);
            }
        }

        assertNotNull(employeeNode);
        NodeList employeeChildren = employeeNode.getChildNodes();
        assertNotEquals(0, employeeChildren.getLength());

        for (int i = 0; i < employeeChildren.getLength(); i++) {
            if (employeeChildren.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            if (!employeeChildren.item(i).getNodeName().equals("employee")) continue;

            String passNumber = null, fullName = null;
            int hours = 0, salary = 0;

            passNumber = employeeChildren.item(i).getAttributes().getNamedItem("passNumber").getNodeValue();
            NodeList empChildren = employeeChildren.item(i).getChildNodes();

            assertNotEquals(0, empChildren.getLength());
            for (int j = 0; j < empChildren.getLength(); j++) {
                if (empChildren.item(j).getNodeType() != Node.ELEMENT_NODE) continue;
                switch (empChildren.item(j).getNodeName()) {
                    case "fullName": fullName = empChildren.item(j).getTextContent(); break;
                    case "hours": hours = Integer.parseInt(empChildren.item(j).getTextContent()); break;
                    case "salary": salary = Integer.parseInt(empChildren.item(j).getTextContent()); break;
                }
            }

            assertNotNull(passNumber);
            assertNotNull(fullName);
            assertNotEquals(0, hours);
            assertNotEquals(0, salary);
        }
    }

    @Test
    public void countHoursTest() {
        Enterprise erp = new Enterprise();
        erp.setEmployees(EmployeeList.getEmployeeList(XML_FILE));

        assertNotEquals(0, erp.getEmployees().size());
        int sumHours = 0;
        for (int i = 0; i < erp.getEmployees().size(); i++) {
            sumHours += erp.getEmployees().get(i).getHours();
        }

        assertEquals(1491, sumHours);
    }

    @Test
    public void countSalaryTest() {
        Enterprise erp = new Enterprise();
        erp.setEmployees(EmployeeList.getEmployeeList(XML_FILE));

        assertNotEquals(0, erp.getEmployees().size());
        int sumSalary = 0;
        for (int i = 0; i < erp.getEmployees().size(); i++) {
            sumSalary += erp.getEmployees().get(i).getSalary();
        }

        assertEquals(8868, sumSalary);
    }

    @Test
    public void countAverageAgeTest() {
        Enterprise erp = new Enterprise();
        erp.setAdministration(AdministrationList.getAdministrationList(XML_FILE));

        assertNotEquals(0, erp.getAdministration().size());
        int avgAge = 0;
        for (int i = 0; i < erp.getAdministration().size(); i++) {
            avgAge += (erp.getAdministration().get(i).getAge() / erp.getAdministration().size());
        }

        assertEquals(46, avgAge);
    }

    @Test
    public void countAverageStageTest() {
        Enterprise erp = new Enterprise();
        erp.setAdministration(AdministrationList.getAdministrationList(XML_FILE));

        assertNotEquals(0, erp.getAdministration().size());
        int avgStage = 0;
        for (int i = 0; i < erp.getAdministration().size(); i++) {
            avgStage += (erp.getAdministration().get(i).getStage() / erp.getAdministration().size());
        }

        assertEquals(12, avgStage);
    }
}
