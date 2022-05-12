package commands;

import utility.CollectionManager;

import java.util.List;

/**
 * The command class for remove_any_by_type.
 */
public class RemoveAnyByNumberOfRooms extends AbstractCommand {
    final int countOfArguments = 1;
    /**
     * Class constructor
     *
     * @param collection class for remove elements from collection
     */
    public RemoveAnyByNumberOfRooms(CollectionManager collection) {
        super(collection);
    }



    /**
     * Removes an item from the collection if its type the input value.
     * @param arguments type of elements which we need to remove
     */
    @Override
    public void execute(List<Object> arguments) {
        Long numberOfRooms = (Long) arguments.get(0);
        collectionManager.removeIf(flat -> flat.getNumberOfRooms().equals(numberOfRooms));

    }
}
