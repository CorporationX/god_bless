package school.faang.thirdStream.BJS2_37117;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@RequiredArgsConstructor
public class Game {
    private static final double HIT_PROBABILITY = 0.33;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final List<Player> players;
    private int totalScore = 0;
    private int totalLives = 0;

    public void startGame() {
        ExecutorService service = Executors.newFixedThreadPool(players.size());
        totalLives = players.stream().mapToInt(Player::getLives).sum();
        players.forEach(player -> service.execute(() -> gamePlay(player)));
        service.shutdown();
        checkServiceTermination(service);
        gameOver();
    }

    private void gameOver() {
        System.out.println("\nИгра окончена\n");
        System.out.printf("Общее количество очков: %d%n%n", totalScore);
        System.out.println("MVP: ");
        players.stream()
                .sorted(Comparator.comparing(Player::getScore).reversed())
                .limit(1)
                .forEach(player -> System.out.println(player.getName() + " : " + player.getScore()));
    }

    private void gamePlay(Player player) {
        while (player.getLives() > 0) {
            update(player);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Thread has been interrupted " + e.getMessage());
            }
        }
        System.out.printf("Игрок %s мертв! Очки: %s%n", player.getName(), player.getScore());
    }

    private void update(Player player) {
        if (checkIsInjured()) {
            synchronized (livesLock) {
                player.setLives(player.getLives() - 1);
                totalLives -= 1;
                System.out.printf("%s подвергается атаке!\t Осталось %d жизней!\t Осталось жизней команды: %d%n",
                        player.getName(), player.getLives(), totalLives);
            }
        } else {
            synchronized (scoreLock) {
                player.setScore(player.getScore() + 1);
                totalScore += 1;
                System.out.printf("%s заработал очко!\t Очки игрока: %d\t Общие очки команды: %d%n",
                        player.getName(), player.getScore(), totalScore);
            }
        }
    }

    private boolean checkIsInjured() {
        return Math.random() < HIT_PROBABILITY;
    }

    private void checkServiceTermination(ExecutorService service) {
        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
    }
}
