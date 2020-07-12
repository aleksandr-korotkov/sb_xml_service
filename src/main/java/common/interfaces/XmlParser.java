package common.interfaces;

import java.util.Optional;

public interface XmlParser<E> {

    Optional<E> convertXmlToObject();
}
