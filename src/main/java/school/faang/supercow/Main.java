package school.faang.supercow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss diablo = new Boss("Diablo", 4);

        List<Player> players = Arrays.asList(new Player("Mage"),
                new Player("Warrior"), new Player("Rogue"),
                new Player("Archer"), new Player("Sorcerer"));

        List<Thread> threads = new ArrayList<>();

        for (Player player : players){
            threads.add(new Thread(() -> {
                try {
                    player.startBattle(diablo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }

        for (Thread thread : threads){
            thread.start();
        }
    }
}
