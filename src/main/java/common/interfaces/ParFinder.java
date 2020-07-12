package common.interfaces;

import entities.Par;
import entities.RootElement;

import java.util.Optional;

public interface ParFinder {

    Optional<Par> findByAttributes(RootElement rootElement, int step, String name);
}
