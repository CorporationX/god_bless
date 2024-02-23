package faang.school.godbless.broforce2974;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BroForce {
    public static void main(String[] args) throws InterruptedException {
        List<Player> players = createPlayersList();
        Game game = new Game();
        ExecutorService gameExecutor = Executors.newFixedThreadPool(4);

        for (Player player : players) {
            gameExecutor.submit(() -> game.startGame(player));
        }
        gameExecutor.shutdown();
        gameExecutor.awaitTermination(2L, TimeUnit.SECONDS);
        printLeaderBoard(players);
    }

    private static List<Player> createPlayersList() {
        return new ArrayList<>(List.of(
                new Player("Player158965"),
                new Player("Pew-pew"),
                new Player("Shroud"),
                new Player("Kotleta")
        ));
    }

    private static void printLeaderBoard(List<Player> players) {
        final int[] position = {1};
        System.out.println("""
                =======================
                ===== *GAME OVER* =====
                =======================
                Leaderboard:""");

        players.stream()
                .sorted(Comparator.comparingInt(Player::getScores).reversed())
                .forEach(player -> {
                    System.out.printf("""
                            %d. %s - %d scores;
                            """, position[0], player.getName(), player.getScores());
                    position[0]++;
                });
    }
}
