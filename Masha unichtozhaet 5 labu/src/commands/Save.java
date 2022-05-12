package commands;

//import com.google.gson.Gson;
import com.google.gson.Gson;
import data.Flat;
import utility.CollectionManager;
import utility.Console;

import java.io.*;
import java.util.List;

/**
 * The command class for save.
 */
public class Save extends AbstractCommand {
    final int countOfArguments = 1;
    /**
     * Class constructor
     *
     * @param collection       class for save elements from collection
     */
    public Save(CollectionManager collection) {
        super(collection);
    }


    /**
     * save collection into file.csv
     *
     * @param arguments empty list
     */
    @Override
    public void execute(List<Object> arguments) {
        String outputFileName = collectionManager.getPathForFile();
        Gson gson = new Gson();
        String json = gson.toJson(collectionManager.getAllElements());
        try {
            OutputStreamWriter osWriter = new OutputStreamWriter(new FileOutputStream(outputFileName));
            osWriter.write(json);
            System.out.println("Collection has been saved successfully.");
            osWriter.close();
        } catch (Exception e) {
            System.out.println("Ошибка доступа к файлу");
        }
    }
}