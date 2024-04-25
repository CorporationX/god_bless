package faang.school.godbless.sprint_3.bro_force;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

@Data
@Slf4j
public class Game {
    private final Object scoreLock;
    private final Object livesLock;
    private int score;
    private int lives;
    private boolean isGameOver;
    private List<Person> personList;

    public Game() {
        this.personList = new ArrayList<>();
        this.livesLock = new Object();
        this.scoreLock = new Object();
    }

    public void addPerson(Person person) {
        synchronized (livesLock) {
            personList.add(person);
            lives += person.getLives();
        }
    }

    public void update() {
        Random random = new Random();
        int randInt = random.nextInt(2);
        Optional<UpdateType> type = Arrays.stream(UpdateType.values())
                .filter(t -> t.ordinal() == randInt)
                .findFirst();

        if (type.isEmpty()) {
            throw new NoSuchElementException("No updateType present");
        }

        switch (type.get()) {
            case MINUS_LIVE -> {
                synchronized (livesLock) {
                    Person person = personList.get(random.nextInt(personList.size()));
                    person.setLives(person.getLives() - 1);
                    log.info("Person with name {} has {} lives.", person.getName(), person.getLives());
                    if (!isPersonAlive(person)) {
                        gameOver();
                    }
                }
            }
            case PLUS_SCORE -> {
                synchronized (scoreLock) {
                    score++;
                    log.info("Current score: {}", score);
                }
            }
        }
    }

    private boolean isPersonAlive(Person person) {
        return person.getLives() > 0;
    }

    public void gameOver() {
        isGameOver = true;
    }
}