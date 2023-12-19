package lab4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DOM_parser {

    public static void main(String[] args) {
        try {
            // Создаем построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            // Загружаем XML-файл из файла
            Document document = documentBuilder.parse(new File("tech_store.xml"));

            // Получаем корневой элемент
            Element root = document.getDocumentElement();

            // Ввод города с клавиатуры
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите город: ");
            String inputCity = scanner.nextLine();

            // Получаем список магазинов
            NodeList storeList = root.getElementsByTagName("store");

            // Итерируемся по каждому магазину
            for (int i = 0; i < storeList.getLength(); i++) {
                Node storeNode = storeList.item(i);

                if (storeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element storeElement = (Element) storeNode;

                    // Получаем атрибуты магазина
                    String city = storeElement.getAttribute("city");
                    String street = storeElement.getAttribute("street");

                    // Проверяем, соответствует ли магазин введенному городу
                    if (inputCity.equalsIgnoreCase(city)) {
                        System.out.println("Магазин: " + city + ", " + street);

                        // Получаем список товаров в магазине
                        NodeList itemNodeList = storeElement.getElementsByTagName("item");
                        Set<String> brandsInStore = new HashSet<>();

                        // Итерируемся по каждому товару
                        for (int j = 0; j < itemNodeList.getLength(); j++) {
                            Node itemNode = itemNodeList.item(j);

                            if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element itemElement = (Element) itemNode;

                                // Получаем данные о товаре
                                String company = itemElement.getElementsByTagName("company").item(0).getTextContent();
                                String type = itemElement.getElementsByTagName("type").item(0).getTextContent();
                                String model = itemElement.getElementsByTagName("model").item(0).getTextContent();
                                String price = itemElement.getElementsByTagName("price").item(0).getTextContent();

                                brandsInStore.add(company);

                                System.out.println("  Фирма: " + company);
                                System.out.println("  Товар: " + type);
                                System.out.println("  Модель: " + model);
                                System.out.println("  Цена: " + price);
                                System.out.println();
                            }
                        }

                        // Выводим все бренды для данного магазина
                        System.out.println("Бренды в магазине: " + String.join(", ", brandsInStore));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}