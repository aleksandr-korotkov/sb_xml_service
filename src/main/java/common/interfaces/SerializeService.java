package common.interfaces;

import entities.Par;

import java.util.List;

public interface SerializeService<E> {

    void serialize(List<E> documents);

    void serialize(Par par);
}
