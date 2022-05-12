/**
 * Class to work with collection
 */
package utility;

import data.Flat;
import utility.interfaces.CollectionManagerInterface;

import java.util.*;
import java.util.function.Predicate;

public class CollectionManager implements CollectionManagerInterface {
    public String initTime;
    private final PriorityQueue<Flat> collection;
    private String pathForFile = "";

    /**
     * Class constructor
     */
    public CollectionManager() {
        collection = new PriorityQueue<>();
        initTime = new Date().toString();
    }

    /**
     * Adds new element into collection.
     *
     * @param flat new element
     */
    public void add(Flat flat) {
        collection.add(flat);
    }

    /**
     * Clear collection.
     */
    public void clear() {
        collection.clear();
    }

    /**
     * @return size of collection
     */
    public int size() {
        return collection.size();
    }

    /**
     * @return initialization time of collection.
     */
    public String getInitTime() {
        return initTime;
    }

    public Flat getMaxElement() {
        Flat maxElem = head();
        for (Flat flat : collection) {
            if(flat.compareTo(maxElem) > 0) {
                maxElem = flat;
            }
        }
        return maxElem;
    }

    /**
     * @return all elements of collection in List.
     */
    public List<Flat> getAllElements(){
        return new ArrayList<>(collection);
    }

    /**
     * @return iterator of collection.
     */
    public Iterator<Flat> iterator(){
        return collection.iterator();
    }

    /**
     * Remove element from collection if it is matches the filter.
     */
    public void removeIf(Predicate<Flat> filter) {
        Objects.requireNonNull(filter);
        collection.removeIf(filter);
    }

    /**
     * Gets the element by ID.
     *
     * @param id of element.
     * @return element by id.
     */
    public Flat get(Integer id) {
        for (Flat flat : collection) {
            if(Objects.equals(flat.getId(), id)) {
                return flat;
            }
        }
        return null;
    }

    /**
     * Replace old Flat with new Flat
     * @param oldFlat flat to replace
     * @param newFlat new flat
     */
    public void replace(Flat oldFlat, Flat newFlat) {
        collection.remove(oldFlat);
        add(newFlat);
    }

    /**
     * Removes first element from collection.
     *
     * @return element that was removed.
     */
    public Flat removeFirst() {
        return collection.poll();
    }

    /**
     * @return first element of collection
     */
    public Flat head() {
        return collection.peek();
    }

    /**
     * Sets the path to file
     *
     * @param path path to file
     */
    public void setPathForFile(String path){
        pathForFile = path;
    }

    /**
     * @return path to file
     */
    public String getPathForFile(){
        return pathForFile;
    }
}