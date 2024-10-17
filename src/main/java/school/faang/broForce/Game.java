package school.faang.broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static final Random random = new Random();

    private int score = 0;
    private int lives = 0;
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addLotsPlayers(List<Player> playerList) {
        players.addAll(playerList);
    }

    public boolean update() {
        Player currentPlayer = players.get(random.nextInt(players.size()));
        boolean alive = currentPlayer.isAlive();
        boolean earnedPoints = random.nextInt(10) < 5;
        boolean lostLife = random.nextInt(10) < 2;

        if (alive) {
            synchronized (scoreLock) {
                if (earnedPoints) {
                    currentPlayer.setScore(currentPlayer.getScore() + 1);
                    score++;
                    System.out.println(currentPlayer.getName() + " scored, now having " + currentPlayer.getScore());
                }
            }
            synchronized (liveLock) {
                if (lostLife) {
                    currentPlayer.setLives(currentPlayer.getLives() - 1);
                    lives++;
                    System.out.println(currentPlayer.getName() + " lost life, now having " + currentPlayer.getLives());
                    if (players.stream().noneMatch(Player::isAlive)) {
                        return gameOver();
                    }
                }
            }
        }
        return false;
    }

    public boolean gameOver() {
        System.out.println("Game over. Final scores: ");
        players.forEach(player -> System.out.println(player.getName() + ": " + player.getScore()));
        System.out.println("Total score: " + score);
        System.out.println("Total lives lost: " + lives);
        return true;
    }
}