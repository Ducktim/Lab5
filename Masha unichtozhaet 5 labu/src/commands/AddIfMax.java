/**
 * The command class for add_if_max.
 */

package commands;

import data.Flat;
import utility.CollectionManager;

import java.util.List;

public class AddIfMax extends Add{

    final int countOfArguments = 10;

    /**
     * Class constructor
     *
     * @param collection class for add new elements to collection
     */
    public AddIfMax(CollectionManager collection) {
        super(collection);
    }

    @Override
    public void execute(List<Object> arguments) {
        Flat flat = createObject(arguments);
        if(flat.compareTo(collectionManager.getMaxElement()) > 0) {
            collectionManager.add(flat);
        }
    }
}
