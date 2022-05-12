import utility.*;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        collectionManager.setPathForFile(System.getenv("PATH_FILE"));
        //collectionManager.setPathForFile("input.json");
        Invoker invoker = new Invoker(collectionManager);
        ArgumentsParser.loadCollection(collectionManager);
        String command = "";
        while(command != null || !command.equals("exit")) {
            try {
                command = Console.next();
            } catch (NoSuchElementException ignored) {}
            invoker.execute(command);
        }
    }
}
