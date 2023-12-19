package lab5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

class DomParser {

    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new File("tech_store.xml"));
            Element root = document.getDocumentElement();

            // Счетчик статистики
            StatCounter statisticsCounter = StatCounter.getInstance();
            Observer observer = new StatObserver();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите город: ");
            String inputCity = scanner.nextLine();

            NodeList storeList = root.getElementsByTagName("store");

            for (int i = 0; i < storeList.getLength(); i++) {
                Node storeNode = storeList.item(i);

                if (storeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element storeElement = (Element) storeNode;
                    String city = storeElement.getAttribute("city");
                    String street = storeElement.getAttribute("street");

                    if (inputCity.equalsIgnoreCase(city)) {
                        System.out.println("Магазин: " + city + ", " + street);

                        // Уведомление о событии
                        observer.update("store");

                        NodeList itemNodeList = storeElement.getElementsByTagName("item");

                        for (int j = 0; j < itemNodeList.getLength(); j++) {
                            Node itemNode = itemNodeList.item(j);

                            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element itemElement = (Element) itemNode;
                                String company = itemElement.getElementsByTagName("company").item(0).getTextContent();
                                String type = itemElement.getElementsByTagName("type").item(0).getTextContent();
                                String model = itemElement.getElementsByTagName("model").item(0).getTextContent();
                                String price = itemElement.getElementsByTagName("price").item(0).getTextContent();

                                // Уведомление о событии
                                observer.update("brand");

                                System.out.println("  Фирма: " + company);
                                System.out.println("  Товар: " + type);
                                System.out.println("  Модель: " + model);
                                System.out.println("  Цена: " + price);
                                System.out.println();
                            }
                        }
                    }
                }
            }

            statisticsCounter.displayStatistics();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
