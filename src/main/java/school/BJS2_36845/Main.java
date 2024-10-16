package school.BJS2_36845;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int MAX_PLAYER = 3;
    private static final List<Player> players = new ArrayList<>();

    public static void main(String[] args) {

        Boss boss = new Boss(MAX_PLAYER);
        initializeOfPlayers();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        players.stream().forEach(player -> executorService.execute(() -> {
            try {
                player.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.shutdown();
    }

    private static void initializeOfPlayers() {
        Player player_1 = new Player("Рома");
        Player player_2 = new Player("Вика");
        Player player_3 = new Player("Костя");
        Player player_4 = new Player("Ваня");
        Player player_5 = new Player("Саша");
        players.add(player_1);
        players.add(player_2);
        players.add(player_3);
        players.add(player_4);
        players.add(player_5);
    }
}
