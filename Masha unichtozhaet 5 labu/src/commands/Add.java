/**
 * The command class for add.
 */

package commands;
import data.*;
import utility.CollectionManager;
import utility.Console;
import java.util.List;

public class Add extends AbstractCommand {
    final int countOfArguments = 10;
    /**
     * Class constructor
     *
     * @param collection class for add new elements to collection
     */
    public Add(CollectionManager collection){
        super(collection);
    }
    public int getCountOfArguments() {
        return countOfArguments;
    }


    public void execute(List<Object> arguments) {
        Flat flat = createObject(arguments);
        if (Console.getReadFromFileStatus()) {
            if (flat == null) {
                System.out.println("Ошибка входных данных в скрипте, файл не был создан");
            } else {
                collectionManager.add(flat);
                System.out.println("Объект был создан\n");
            }
        } else {
            collectionManager.add(flat);
            System.out.println("Объект был создан\n");
        }
    }


    /**
     * Creates an object of the Flat class based on the list of arguments passed to it.
     * @param arguments arguments for create a new Flat.
     *
     * @return Flat or null in case can't create a new Flat.
     */
    protected Flat createObject(List<Object> arguments){
        int i = 0;
        try {
            String name = (String) arguments.get(i++);
            Double coordinatesX = (Double) arguments.get(i++);
            Double coordinatesY = (Double) arguments.get(i++);
            Coordinates coordinates = new Coordinates(coordinatesX, coordinatesY);
            View view = (View) arguments.get(i++);
            Transport transport = (Transport) arguments.get(i++);
            Float area = (Float) arguments.get(i++);
            Long numberOfRooms = (Long) arguments.get(i++);
            Float livingspace = (Float) arguments.get(i++);
            Long year = (Long) arguments.get(i++);
            Integer numberOfFlatsOnFloor = (Integer) arguments.get(i++);
            Long numberOfLifts = (Long) arguments.get(i);
            House house = new House(name, year, numberOfFlatsOnFloor, numberOfLifts);
            return new Flat(name, coordinates,  area, numberOfRooms,livingspace, view, transport,house);
        } catch (Exception e) {
            System.out.println("Неправильные входные данные. Объект не был создан");
            e.printStackTrace();
        }
        return null;
    }
}