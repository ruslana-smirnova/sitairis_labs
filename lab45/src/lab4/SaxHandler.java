package lab4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

class SaxHandler extends DefaultHandler {

    private String currentElement;
    private String currentCity;
    private String currentStreet;
    private Set<String> currentBrands;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if ("store".equals(currentElement)) {
            currentCity = attributes.getValue("city");
            currentStreet = attributes.getValue("street");
            currentBrands = new HashSet<>();
            System.out.println("Магазин: " + currentCity + ", " + currentStreet);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (!value.isEmpty()) {
            if ("company".equals(currentElement)) {
                currentBrands.add(value);
                System.out.println("  Фирма: " + value);
            } else if ("type".equals(currentElement)) {
                System.out.println("  Вид: " + value);
            } else if ("model".equals(currentElement)) {
                System.out.println("  Модель: " + value);
            } else if ("price".equals(currentElement)) {
                System.out.println("  Цена: " + value + "\n");
            }
        }
    }
}