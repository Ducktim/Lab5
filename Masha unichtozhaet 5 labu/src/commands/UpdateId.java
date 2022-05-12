package commands;

import data.*;
import utility.CollectionManager;
import java.util.List;

/**
 * Class for command update_id
 */
public class UpdateId extends AbstractCommand {
    final int countOfArguments = 11;
    /**
     * Class constructor
     *
     * @param collection class for update elements from collection
     */
    public UpdateId(CollectionManager collection) {
        super(collection);
    }

    /**
     * Creates an object of the class based on the list of arguments passed to it.
     * @param arguments arguments for create a new Flat.
     * @return Flat
     * @throws NullPointerException - can't create a new Flat.
     */
    protected Flat createObject(List<Object> arguments){
        int i = 1;
        try {
            String name = (String) arguments.get(i++);
            Double coordinatesX = (Double) arguments.get(i++);
            Double coordinatesY = (Double) arguments.get(i++);
            Coordinates coordinates = new Coordinates(coordinatesX, coordinatesY);
            View view = (View) arguments.get(i++);
            Transport transport = (Transport) arguments.get(i++);
            Float area = (Float) arguments.get(i++);
            Long numberOfRooms = (Long) arguments.get(i++);
            Float livingSpace = (Float) arguments.get(i++);
            Long year = (Long) arguments.get(i++);
            Integer numberOfFlatsOnFloor = (Integer) arguments.get(i++);
            Long numberOfLifts = (Long) arguments.get(i);
            House house = new House(name, year, numberOfFlatsOnFloor, numberOfLifts);
            return new Flat(name, coordinates,  area, numberOfRooms,livingSpace, view, transport,house);
        } catch (Exception e) {
            System.out.println("Неправильные входные данные. Объект не был создан");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update the id of the object that based on input values.
     * @param arguments id of element which we need to update
     */
    @Override
    public void execute(List<Object> arguments) {
        Flat flat = collectionManager.get((Integer) arguments.get(0));
        if(flat == null) {
            System.out.println("Element doesn't exist.");
            return;
        }
        collectionManager.replace(flat, createObject(arguments));
        System.out.println("Element was successfully updated.");
    }
}