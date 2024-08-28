package com.multithreading.force;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private int score;
    private int lives;
    private final Statistics statistics = new Statistics();
    @Getter
    private List<Player> players = new ArrayList<>();

    private final Lock lock = new ReentrantLock();

    public void update(Player player) {
        int livesInPlayer = player.getLives();
        while (livesInPlayer > 0) {
            lock.lock();
            try {
                int scoreRandom = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
                score += scoreRandom;
                player.setScore(player.getScore() + scoreRandom);
            } finally {
                lock.unlock();
            }

            lock.lock();
            try {
                livesInPlayer -= 1;
                lives++;
            } finally {
                lock.unlock();
            }
        }
        gameOver();
    }


    private void gameOver() {
        statistics.setTotalScore(score);
        statistics.setTotalLives(lives);
    }

    public void getStatistics() {
        System.out.println("\nStatistics: " + "\nTotal score = " +
                statistics.getTotalScore() +
                "\nTotal lives: " + statistics.getTotalLives() + "\n");
        players.forEach(player -> System.out.println("Player: " +
                player.getName() +
                "\nScore: " +
                player.getScore() +
                "\nThere were lives: " + player.getLives()));
    }

    public void addPlayer(Player player) {
        if (!(player == null)) {
            players.add(player);
        }
    }

}
