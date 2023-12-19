package lab4;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAX_parser {

    public static void main(String[] args) {
        try {
            // Создаем фабрику и парсер
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Создаем обработчик SAX-событий
            SaxHandler handler = new SaxHandler();

            // Парсим XML-файл
            saxParser.parse("tech_store.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

