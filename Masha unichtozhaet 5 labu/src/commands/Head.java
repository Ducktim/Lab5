package commands;

import utility.CollectionManager;

import java.util.ArrayList;
import java.util.List;
/**
 * The command class for print_filed_descending_comment.
 */
public class Head extends AbstractCommand {
    /**
     * Class constructor
     *
     * @param collection class for work with collection
     */
    public Head(CollectionManager collection) {
        super(collection);
    }


    /**
     * Prints the values of the comment field of all elements in descending order
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        System.out.println(collectionManager.head());
    }
}