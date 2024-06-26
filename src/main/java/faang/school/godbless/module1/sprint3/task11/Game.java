package faang.school.godbless.module1.sprint3.task11;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Game {
    private int scope;
    private int lives;
    private final Random random;
    private final Object object;
    private boolean isGameOver;

    public Game() {
        this.scope = 0;
        this.lives = 10;
        this.random = new Random();
        this.object = new Object();
        this.isGameOver = false;
    }

    public void update(Fighter first, Fighter second) {
        synchronized (object) {
            while (first.getLives() > 0) {
                first.setLives(first.getLives() - 1);
                second.setScope(second.getScope() + 1);
                System.out.println(first.getName() + " lives " + first.getLives());
                System.out.println(second.getName() + " scope " + second.getScope());
                object.notify();
            }
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("Game over!");
    }

    public synchronized void rollAttack(Fighter first, Fighter second) throws InterruptedException {
        int value = getRandom().nextInt(1, 3);
        switch (value) {
            case 1 -> fight(first, second);
            case 2 -> fight(second, first);
        }
    }

    public void fight(Fighter first, Fighter second) throws InterruptedException {
        synchronized (object) {
            if (first.isAlive()) {
                first.setHeals(first.getHeals() - (second.getDamage() - first.getDefence()));
                if (first.getHeals() < 0) {
                    first.setAlive(false);
                    object.wait();
                    rollAttack(first, second);
                }
            }
        }

    }
}
