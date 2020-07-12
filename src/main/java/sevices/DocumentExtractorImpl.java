package sevices;

import common.interfaces.DocumentExtractor;
import entities.RootElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocumentExtractorImpl implements DocumentExtractor<RootElement,String> {
    private static final String PAR_NAME_WITH_DOCUMENTS = "ВИД_ДОК";

    @Override
    public List<String> extractDocuments(RootElement rootElement) {
        List<String> documents = new ArrayList<>();
        rootElement.getServices().stream().forEach(serv -> serv.getPars().stream().forEach(par -> {
            if(par.getName().equals(PAR_NAME_WITH_DOCUMENTS)){
                par.getParList().stream().forEach(parList -> documents.add(parList.getValue()));
            }
        }));
        Collections.sort(documents);
        return documents;
    }
}
