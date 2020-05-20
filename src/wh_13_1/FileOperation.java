package wh_13_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public final class FileOperation {

    protected FileOperation() {
    }

    static void WriteCSV(String fileName, String CSV_HEADER, List<Player> players) {
        try (
                var fileWriter = new FileWriter(fileName, true);
                var writer = new BufferedWriter(fileWriter);
        ) {
            writer.write(CSV_HEADER);
            writer.newLine();
            for (Player player : players) {
                writer.write(player.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + fileName);
        }

    }

    static void readCSV(String fileName) {
        try (
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void checkFileExist(String fileName) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch (IOException e) {
            System.out.println("Invalid permissions.");
        }

        System.out.println("Deletion successful.");
    }
}
