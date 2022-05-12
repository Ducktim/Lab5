/**
 * Class for parse input arguments.
 */
package utility;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import commands.*;
import commands.interfaces.CommandInterface;
import data.Flat;
import data.Transport;
import data.View;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;

public class ArgumentsParser {
    /**
     * Checks all input values and validates them. Does not check values if Scanner read from file.
     *
     * @return List<Object>
     */
    static public List<Object> parseArguments(CommandInterface command) {
        List<Object> arguments = new ArrayList<>();
        if (!Console.getReadFromFileStatus()) {
            if (command instanceof Add) {
                System.out.println("Введите название");
                arguments.add(Console.next());
                System.out.println("Введите координату x");
                Double x = (Double) read(Double::valueOf);
                while (x <= -960){
                    System.out.println("Повторите ввод");
                    x = (Double) (read(Double::valueOf));
                }
                arguments.add(x);
                System.out.println("Введите координату y");
                arguments.add(read(Double::valueOf));
                System.out.println("Выберите и введите тип из списка:");
                for (View view : View.values()) {
                    System.out.println(view);
                }
                arguments.add(read(View::valueOf));
                System.out.println("Выберите и введите тип из списка:");
                for (Transport t : Transport.values()) {
                    System.out.println(t);
                }
                arguments.add(read(Transport::valueOf));
                System.out.println("Введите размер территории:");
                arguments.add(read(Float::valueOf));
                System.out.println("Введите число комнат:");
                arguments.add(read(Long::valueOf));
                System.out.println("Введите жилую площадь:");
                arguments.add(read(Float::valueOf));
                System.out.println("Введите год:");
                arguments.add(read(Long::valueOf));
                System.out.println("Введите количество квартир на этаже:");
                arguments.add(read(Integer::valueOf));
                System.out.println("Введите количество лифтов:");
                arguments.add(read(Long::valueOf));
                return arguments;
            }

            if (command instanceof ExecuteScript) {
                boolean flag = true;
                while (flag) {
                    String filePath = Console.next();
                    Path path = Paths.get(filePath);
                    try {
                        if (Files.exists(path)) {
                            flag = false;
                            arguments.add(filePath);
                        } else {
                            System.out.println("Файл не существует, повторите ввод");
                        }
                    } catch (SecurityException e) {
                        System.out.println("Ошибка прав доступа к файлу");
                    }
                }
            }

            if (command instanceof RemoveById) {
                arguments.add(read(Long::valueOf));
            }

            if (command instanceof UpdateId) {
                arguments.add(read(Integer::valueOf));
                System.out.println("Введите название:");
                arguments.add(Console.next());
                System.out.println("Введите координату x:");
                Double x = (Double) read(Double::valueOf);
                while (x <= -960){
                    System.out.println("Повторите ввод");
                    x = (Double) (read(Double::valueOf));
                }
                arguments.add(x);
                System.out.println("Введите координату y:");
                arguments.add(read(Double::valueOf));
                System.out.println("Выберите и введите тип из списка:");
                for (View view : View.values()) {
                    System.out.println(view);
                }
                arguments.add(read(View::valueOf));
                System.out.println("Выберите и введите тип из списка:");
                for (Transport t : Transport.values()) {
                    System.out.println(t);
                }
                arguments.add(read(Transport::valueOf));
                System.out.println("Введите размер территории:");
                arguments.add(read(Float::valueOf));
                System.out.println("Введите число комнат:");
                arguments.add(read(Long::valueOf));
                System.out.println("Введите жилую площадь:");
                arguments.add(read(Float::valueOf));
                System.out.println("Введите год:");
                arguments.add(read(Long::valueOf));
                System.out.println("Введите количество квартир на этаже:");
                arguments.add(read(Integer::valueOf));
                System.out.println("Введите количество лифтов:");
                arguments.add(read(Long::valueOf));
                return arguments;
            }

            if (command instanceof FilterByHouse) {
                System.out.println("Введите название:");
                arguments.add(Console.next());
                System.out.println("Введите год:");
                arguments.add(read(Long::valueOf));
                System.out.println("Введите количество квартир на этаже:");
                arguments.add(read(Integer::valueOf));
                System.out.println("Введите количество лифтов:");
                arguments.add(read(Long::valueOf));
            }

            if (command instanceof RemoveAnyByNumberOfRooms) {
                arguments.add(read(Long::valueOf));
            }
        } else {
            arguments = parseArgumentsFromFIle(command);
        }
        return arguments;
    }

    /**
     * @param command - command which arguments need to parse.
     * @return list with (Object) arguments
     */
    public static List<Object> parseArgumentsFromFIle(CommandInterface command) {
        List<Object> arguments = new ArrayList<>();

        for (int i = 0; i < command.getCountOfArguments(); i++) {
            arguments.add(Console.next());
        }

        return arguments;
    }

    /**
     * Loads the collection from file.
     *
     * @param collectionManager collection
     */
    public static void loadCollection(CollectionManager collectionManager) {
        try {
            String filePath = collectionManager.getPathForFile();
            Path path = Paths.get(filePath);
            try {
                if (!Files.exists(path)) {
                    System.out.println("Файл с коллекцией не существует, выходим из программы.");
                    System.exit(0);
                }
            } catch (SecurityException e) {
                System.out.println("Ошибка прав доступа к файлу");
                System.exit(0);
            }
            Gson g = new Gson();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
            char[] array = new char[4096];
            StringBuilder json = new StringBuilder();
            while(inputStreamReader.read(array) != -1) {
                json.append(new String(array));
            }
            Type collectionType = new TypeToken<PriorityQueue<Flat>>(){}.getType();
            PriorityQueue<Flat> collection = g.fromJson(json.toString().trim(), collectionType);
            if(collection == null) {
                return;
            }
            for (Flat obj : collection) {
                if(Validator.validate(collectionManager, obj)) {
                    collectionManager.add(obj);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found. Exit program...");
            System.exit(0);
        }
    }

    /**
     * Validate input for fields
     *
     * @param check - function for validate new field
     * @return the field that passed verification.
     */
    private static Object read(Function<String, Object> check) {
        while (true) {
            String str = Console.next();
            try {
                return check.apply(str);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Ошибка ввода, попробуйте ещё раз");
            }
        }
    }
}


