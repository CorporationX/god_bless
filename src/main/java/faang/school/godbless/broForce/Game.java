package faang.school.godbless.broForce;

import java.util.List;
import java.util.Random;

public class Game {

    private int commonScore;
    private int commonLives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private final List<Person> gamers;
    private final Random greatRandom = new Random();

    public Game(List<Person> gamers) {
        this.gamers = gamers;
        this.commonLives = gamers.stream()
                .mapToInt(Person::getLives)
                .sum();
    }

    public void update() {
        Person activePerson = gamers.get(greatRandom.nextInt(gamers.size()));

        //Coin flip
        switch (greatRandom.nextInt(2)) {
            case 0:
                synchronized (scoreLock) {
                    commonScore++;
                }
                increaseScore(activePerson);
                break;
            case 1:
                synchronized (livesLock) {
                    commonLives--;
                }
                decreaseLives(activePerson);
                break;
        }

        if (gamers.stream()
                .mapToInt(Person::getLives)
                .filter(i -> i == 0)
                .findAny()
                .isPresent()) {
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("Game Over. Somebody died");
        System.out.println("Total score : " + commonScore + " lives left " + commonLives);
        System.exit(0);
    }

    public void increaseScore(Person person) {
        System.out.println("The player " + person.getName() + " completed the level and received a point");
        person.setScore(person.getScore() + 1);
    }

    public void decreaseLives(Person person) {
        System.out.println("The player " + person.getName() + " lost his life");
        person.setLives(person.getLives() - 1);
    }
}
