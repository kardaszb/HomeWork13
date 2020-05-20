package wh_13_1;

import java.util.*;

public final class ReadPlayers {
    private static List<Player> players = new ArrayList<>();

    private ReadPlayers() {
    }

    static List<Player> readFromUser() {
        Scanner sc = new Scanner(System.in);
        String readLine;
        do {
            System.out.println("Podaj wynik kolejnego gracza <Imie Nazwisko wynik> (lub stop):");
            readLine = sc.nextLine();
            if ("stop".equals(readLine) && players.size() == 0) {
                break;
            }
            if ("stop".equals(readLine)) {
                continue;
            } else {
                players = insertData(readLine);
            }
        } while (!"stop".equals(readLine));

        return players;
    }

    private static List<Player> insertData(String playerInfo) {
        String[] data = playerInfo.split(" ");
        if (data.length < 3 || data.length > 3)
            System.out.println("-> Gracz musi posiadac: Imie Nazwisko wynik! \n-> Podaj poprawne dane!");
        else {
            Player player = new Player(data[0], data[1], Integer.parseInt(data[2]));
            players.add(player);
        }
        return players;
    }

}
