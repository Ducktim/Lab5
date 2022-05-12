package utility.interfaces;

import data.*;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public interface CollectionManagerInterface {

    void add(Flat flat);
    void clear();
    int size();
    String getInitTime();
    List<Flat> getAllElements();
    Iterator<Flat> iterator();
    void removeIf(Predicate<Flat> filter);

}
