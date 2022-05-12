
package commands;

import data.Flat;
import utility.CollectionManager;

import java.util.List;
/**
 * The command class for save.
 */
public class Show extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for show elements from collection
     */
    public Show(CollectionManager collection) {
        super(collection);
    }
    
    /**
     * print all elements of collection.
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        if(collectionManager.size() == 0) {
            System.out.println("Collection is empty.");
            return;
        }
        for (Flat flat : collectionManager.getAllElements()) {
            System.out.println(flat.toString());
        }
    }
}
