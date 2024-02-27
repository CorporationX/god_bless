package bro_force;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Game {
    private int score;
    private int lives;
    private Object lockScore = new Object();
    private Object lockLives = new Object();
    private List<Person> persons = new ArrayList<>();
    private Random rnd = new Random();

    public boolean update() {
        int personIndex = rnd.nextInt(persons.size());
        Person person = persons.get(personIndex);
        boolean isDead = rnd.nextBoolean();
        if (isDead) {
            synchronized (lockLives) {
                person.setLives(person.getLives() - 1);
                lives++;
                System.out.println(person.getName() + " livers: " + person.getLives());
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
        List<Integer> list = persons.stream().map(person -> person.getLives()).toList();
        if (list.contains(0)) {
            System.out.println("Game over");
            System.out.println("Max score: " + score);
            System.out.println("Lost lives: " + lives);
            return true;
        }
        return false;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public boolean checkLose() {
        List<Integer> list = persons.stream()
                .map(person -> person.getLives()).toList();
        if (list.contains(0)) {
            return true;
        } else {
            return false;
        }
    }
}
