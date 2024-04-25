package faang.school.godbless.synchronization.task_4.model;

import java.util.List;
import java.util.Random;

public class Game {
    private static final Random GAME_RANDOM = new Random();
    private final List<Player> players;
    private int scores = 0;
    private int lostLives = 0;
    private final Object scoresLock = new Object();
    private final Object lostLivesLock = new Object();

    public Game(List<Player> players) {
        this.players = players;
    }

    public void update() {
        Player player = players.get(GAME_RANDOM.nextInt(players.size()));
        while (player.isAlive()) {
            boolean isRoundWin = GAME_RANDOM.nextBoolean();
            if (isRoundWin) {
                synchronized (scoresLock) {
                    System.out.println("игроки выигрывают раунд");
                    player.setScore(player.getScore() + 1);
                    scores++;
                    System.out.println("количестов набранных очков: " + scores);
                }
            } else {
                synchronized (lostLivesLock) {
                    player.setLives(player.getLives() - 1);
                    lostLives++;
                    System.out.println(player.getName() + " теряет жизнь. осталось: " + player.getLives());
                    if (!player.isAlive()) {
                        gameOver(player);
                        break;
                    }
                }
            }
        }
    }

    private void gameOver(Player player) {
        System.out.println(player.getName() + " проиграл и выбывает из игры");
        System.out.println("количество очков игрока: " + player.getName() + " : " + player.getScore());
        System.out.println("потеряно жизней: " + lostLives);
    }
}