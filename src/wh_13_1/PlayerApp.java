package wh_13_1;

import java.util.*;

public class PlayerApp {
    final static String RESULTS_FILE_NAME = "testResults.csv";
    final static String CSV_HEADER = "firstName;lastName;result";


    public static void main(String[] args) {
        List<Player> playerList = ReadPlayers.readFromUser();

        playerList.sort(Player::compareTo);
        FileOperation.checkFileExist(RESULTS_FILE_NAME);
        FileOperation.WriteCSV(RESULTS_FILE_NAME, CSV_HEADER, playerList);
        FileOperation.readCSV(RESULTS_FILE_NAME);


    }
}
