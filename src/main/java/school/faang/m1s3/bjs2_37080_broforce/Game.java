package school.faang.m1s3.bjs2_37080_broforce;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
@Getter
public class Game {
    private int scoreTotal = 0;
    private int livesTotal = 0;
    private Object lockScoreTotal = new Object();
    private Object lockLivesTotal = new Object();
    private final List<Player> playerList;

    public void startGame(ExecutorService service) {
        livesTotal = playerList.stream().mapToInt(Player::getLives).sum();
        playerList.forEach(player ->
                service.execute(() -> gamePlay(player)));
        service.shutdown();
    }

    public void gameOver() {
        System.out.println();
        System.out.println("The Game is over");
        System.out.println("Total score: " + scoreTotal);
        System.out.println();
        System.out.println("Top players: ");
        playerList.stream()
                .sorted(Comparator.comparing(Player::getScore).reversed())
                .forEach(player -> System.out.println(player.getName() + " : " + player.getScore()));
    }

    private void gamePlay(Player player) {
        while (player.getLives() > 0) {
            update(player);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
            }
        }
        System.out.println(player.getName() + " bravely dies in the name of democracy! His score: " + player.getScore());
    }

    private void update(Player player) {
        if (player.checkIsInjured()) {
            synchronized (lockLivesTotal) {
                player.setLives(player.getLives() - 1);
                livesTotal -= 1;
                System.out.printf("%s is hit by the enemy!! %d lives left!!\t\t\t Team lives left: %d%n",
                        player.getName(), player.getLives(), livesTotal);
            }
        } else {
            synchronized (lockScoreTotal) {
                player.setScore(player.getScore() + 1);
                scoreTotal += 1;
                System.out.printf("%s kills the enemy!! BRO RULZ!! Player score: %d\t\t\t Team total score: %d%n",
                        player.getName(), player.getScore(), scoreTotal);
            }
        }
    }
}
