package faang.school.godbless.synchronizationWaitNotify.broForce;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Game {
    private int score;
    private int lives;
    private List<Character> characters;
    private boolean isOver;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final Random random = new Random();

    public Game() {
        characters = new ArrayList<>();
    }

    public synchronized void addCharacter(Character character) {
        characters.add(character);
        System.out.println("В игру добавлен персонаж " + character.getName());
    }

    public void update(){
        if (characters.isEmpty()) {
            System.out.println("В игре никто не участвует!");
            isOver = true;
        }

        int characterIndex = random.nextInt(characters.size());
        Character character = characters.get(characterIndex);
        boolean isAlive = character.isAlive();

        if (!isAlive) {
            if (isOver)
                return;
            synchronized (livesLock) {
                boolean isDeath = character.decrementAndCheckLives();
                this.lives++;
                System.out.println(Thread.currentThread().getName() + ": " + character.getName() + " lives: " + character.getLives());
                if (isDeath) {
                    gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                character.addPoint();
                this.score++;
            }
        }
    }

    private void gameOver(){
        System.out.println("Game over with score: " + score);
        System.out.println("Lost lives: " + lives);
        isOver = true;
    }
}
