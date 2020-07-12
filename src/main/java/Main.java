import common.interfaces.DocumentExtractor;
import common.interfaces.ParFinder;
import common.interfaces.SerializeService;
import common.interfaces.XmlParser;
import dao.DocumentsRepositoryImpl;
import entities.Par;
import entities.RootElement;
import sevices.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        XmlParser<RootElement> service = new XmlParserImpl();
        RootElement rootElementFromXml = service.convertXmlToObject().orElseThrow(NullPointerException::new);

        DocumentExtractor documentExtractor = new DocumentExtractorImpl();
        List<String> documents =  documentExtractor.extractDocuments(rootElementFromXml);

        ParFinder parFinder = new ParFinderImpl();
        Par par = parFinder.findByAttributes(rootElementFromXml, 1, "ГРАЖДАНСТВО").get();

        SerializeService serializeService = new SerializeServiceImpl();
        serializeService.serialize(documents);
        serializeService.serialize(par);

        DocumentsRepositoryImpl repository = new DocumentsRepositoryImpl();
        List<String> documentsFromDB = repository.findAll().get();
    }
}
