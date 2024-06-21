package faang.school.godbless.multithreading.bro_force;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {

    private String name;
    private int lives;

    public void fight(Enemy enemy, Game game) throws InterruptedException {
        System.out.println("Player: " + name + " start fight");

        while (game.isGame()) {
            if (enemy.hit()) {
                synchronized (game) {
                    game.setScore(game.getScore() + 1);
                    game.notify();
                }
            } else {
                synchronized (game) {
                    lives--;
                    game.setLives(game.getLives() + 1);
                    game.notify();
                }
            }
            Thread.sleep(100);
        }

        System.out.println("Player: " + name + " finish fight");
    }
}