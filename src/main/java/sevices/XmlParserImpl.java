package sevices;

import common.interfaces.XmlParser;
import entities.RootElement;

import javax.xml.bind.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.util.Optional;

public class XmlParserImpl implements XmlParser {

    private static final String XML_SOURCE = "src/main/resources/";
    private static final String PRODUCTS_XML_FILE_NAME = "order.xml";
    private static final String XML_ROOT_ELEMENT = "order";

    public Optional<RootElement> convertXmlToObject() {
        try {
            StreamSource xml = new StreamSource(XML_SOURCE + PRODUCTS_XML_FILE_NAME);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xif.createXMLStreamReader(xml);
            xmlStreamReader.nextTag();
            while (!xmlStreamReader.getLocalName().equals(XML_ROOT_ELEMENT)) {
                xmlStreamReader.nextTag();
            }
            JAXBContext jc = JAXBContext.newInstance(RootElement.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<RootElement> jb = unmarshaller.unmarshal(xmlStreamReader, RootElement.class);
            xmlStreamReader.close();
            return Optional.of(jb.getValue());
        }
        catch (XMLStreamException e){
            e.printStackTrace();
        }
        catch (JAXBException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

