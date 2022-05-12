package utility;

import commands.ExecuteScript;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    public static Scanner scannerIn = new Scanner(System.in);
    public static boolean readFromFileStatus = false;

    /**
     * Read next element in scanner and check it
     * @return next String in scanner
     */
    static public String next() throws NoSuchElementException,IllegalArgumentException {
        if (readFromFileStatus) {
            if (!scannerIn.hasNextLine()) {
                scannerIn = new Scanner(System.in);
                ExecuteScript.deleteLastPath();
            }
        }

        String data;
        try {
            data = scannerIn.next().replaceAll("\\p{C}", "?").trim();
            if (data.length() > 100) {
                System.out.println("Нельзя вводить более 100 символов в одной строке.");
                return "";
            }
        } catch (NoSuchElementException e) {
            System.out.println("Выход из программы...");
            System.exit(0);
            return null;
        }
        return data;
    }

    /**
     * Check read from file is enabled or not.
     *
     * @return true if reads from file, else false.
     */
    public static boolean getReadFromFileStatus() {
        return readFromFileStatus;
    }

    /**
     * Sets read from file status.
     *
     * @param status status read of file.
     */
    public static void setReadFromFileStatus(boolean status) {
        readFromFileStatus = status;
    }
}
