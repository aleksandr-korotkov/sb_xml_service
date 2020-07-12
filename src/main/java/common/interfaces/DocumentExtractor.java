package common.interfaces;

import java.util.List;

public interface DocumentExtractor<E,T> {

    List<T> extractDocuments(E rootElement);

}
