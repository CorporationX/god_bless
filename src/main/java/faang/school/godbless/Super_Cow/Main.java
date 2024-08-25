package faang.school.godbless.Super_Cow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Jack");
        Player player2 = new Player("Rob");
        //Player player3 = new Player("George");
        //Player player4 = new Player("Owo");
        //Player player5 = new Player("Mat");
        List<Player> currentPlayers1 = new ArrayList<>();
        Boss boss1 = new Boss(5, currentPlayers1);
        Thread thread1 = new Thread(() ->boss1.joinBattle(player1));
        Thread thread2 = new Thread(() ->boss1.startBattle(boss1,player2));
        thread1.start();
        thread2.start();
    }
}