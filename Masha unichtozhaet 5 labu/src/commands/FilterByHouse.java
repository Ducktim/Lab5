package commands;

import data.Flat;
import data.House;
import utility.CollectionManager;

import java.util.List;
/**
 * The command class for remove_by_id.
 */
public class FilterByHouse extends AbstractCommand{
    final int countOfArguments = 4;
    /**
     * Class constructor
     *
     * @param collection class for work with elements from collection
     */
    public FilterByHouse(CollectionManager collection) {
        super(collection);
    }


    /**
     * Prints all elements which house is lower than given.
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        String name = (String) arguments.get(0);
        Long year = (Long) arguments.get(1);
        Integer numberOfFlatsOnFloor = (Integer) arguments.get(2);
        Long numberOfLifts = (Long) arguments.get(3);
        House house = new House(name, year, numberOfFlatsOnFloor, numberOfLifts);
        for (Flat flat : collectionManager.getAllElements()) {
            if(flat.getHouse().compareTo(house) == 0) {
                System.out.println(flat);
            }
        }
    }
}