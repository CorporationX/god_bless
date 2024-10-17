package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        List<Player> clan = new ArrayList<>();
        int quantityOfPlayers = 30;

        for (int i = 1; i <= quantityOfPlayers; i++) {
            clan.add(new Player("игрок номер " + i));
        }

        clan.stream()
            .forEach(
                x -> {
                    Thread thread = new Thread(
                            () -> {
                                try {
                                    System.out.println(x.getName() +
                                            " зашел в данж");
                                    x.startBattle(boss);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    );
                    thread.start();
                }
            );
    }

}
