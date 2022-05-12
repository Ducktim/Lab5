package utility;


import commands.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Invoker {
    private final CollectionManager collectionManager;
    private final Map<String, AbstractCommand> commands;

    /**
     * Class constructor.
     *
     * @param aCollectionManager collection
     */
    public Invoker(CollectionManager aCollectionManager){
        collectionManager = aCollectionManager;
        commands = new HashMap<>();
        initMap();
    }

    /**
     * Executes command.
     *
     * @param newCommand command that need to execute.
     */
    public void execute(String newCommand){
        if(newCommand == null || newCommand.equals("")) {
            return;
        }
        if(commands.containsKey(newCommand)){
            AbstractCommand command = commands.get(newCommand);
            List<Object> arguments = ArgumentsParser.parseArguments(command);
            command.execute(arguments);
        }else{
            System.out.println("\tWrong command");
        }
    }

    /**
     * Adds command to list for its next execution.
     */
    public void initMap(){
        commands.put("add", new Add(collectionManager));
        commands.put("add_if_max", new AddIfMax(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("execute_script", new ExecuteScript(collectionManager));
        commands.put("exit", new Exit(collectionManager));
        commands.put("filter_by_house", new FilterByHouse(collectionManager));
        commands.put("head", new Head(collectionManager));
        commands.put("help", new Help(collectionManager));
        commands.put("info", new Info(collectionManager));
        commands.put("print_ascending", new PrintAscending(collectionManager));
        commands.put("remove_any_by_number_of_rooms", new RemoveAnyByNumberOfRooms(collectionManager));
        commands.put("remove_by_id", new RemoveById(collectionManager));
        commands.put("remove_first", new RemoveFirst(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("update_id", new UpdateId(collectionManager));
    }
}
