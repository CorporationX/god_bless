package bro_force;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Game {
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();
    private List<Person> personList;
    private Random random = new Random();

    public Game() {
        this.personList = new ArrayList<>();
    }

    public boolean update() {
        int personIndex = random.nextInt(personList.size());
        Person person = personList.get(personIndex);
        boolean isDead = random.nextBoolean();
        if (isDead) {
            synchronized (lockLives) {
                if (person.getLives() > 0) {
                    person.setLives(person.getLives() - 1);
                    lives++;
                    System.out.println(person.getName() + " livers: " + person.getLives());
                }
                if (person.getLives() == 0) {
                    return gameOver();
                }
            }
        } else {
            synchronized (lockScore) {
                person.setScore(person.getScore() + 1);
                score++;
            }
        }
        return false;
    }

    private boolean gameOver() {
        List<Integer> list = personList.stream().map(person -> person.getLives()).toList();
        if (list.contains(0)) {
            System.out.println("Game over");
            System.out.println("Max score: " + score);
            System.out.println("Lost lives: " + lives);
            return true;
        }
        return false;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public boolean checkLose() {
        List<Integer> list = personList.stream()
                .map(person -> person.getLives()).toList();
        if (list.contains(0)) {
            return true;
        } else {
            return false;
        }
    }
}
