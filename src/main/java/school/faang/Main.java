package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //создаем босса, создаем клан и задаем количество игроков,
        // которые будут приняты в клан и отправлены на зачистку данжа
        Boss boss = new Boss();
        List<Player> clan = new ArrayList<>();
        int quantityOfPlayers = 30;

        //создаем каждого игрока и принимаем в клан
        for (int i = 1; i <= quantityOfPlayers; i++) {
            Player player = new Player("игрок номер " + i);
            clan.add(player);
        }

        //запускаем игроков в данж, каждого в своем потоке
        for (Player player : clan) {
            Thread thread = new Thread(
                    () -> {
                        try {
                            System.out.println(player.getName() +
                                                              " зашел в данж");
                            player.startBattle(boss);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
            thread.start();
        }
    }

}
