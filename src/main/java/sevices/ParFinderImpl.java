package sevices;

import common.interfaces.ParFinder;
import entities.Par;
import entities.RootElement;

import java.util.Optional;

public class ParFinderImpl implements ParFinder {

    @Override
    public Optional<Par> findByAttributes(RootElement rootElement, int step, String name) {
        final Par[] retPar = {null};
        rootElement.getServices().stream().forEach(serv -> serv.getPars().stream().forEach(par -> {
            if(par.getStep()==step&&par.getName().equals(name)){
                retPar[0] = par;
            }
        }));
        return Optional.of(retPar[0]);
    }
}
