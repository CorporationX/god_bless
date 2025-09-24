package school.faang.bjs2_93110;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        School hogwarts = new School("Hogwarts", List.of(
                new Student("Harry", 2025),
                new Student("Ron", 2025),
                new Student("Hermione", 2025)
        ));
        School durmstrang = new School("Durmstrang", List.of(
                new Student("Draco", 2025),
                new Student("Vincent", 2025)
        ));
        tournament.startTask(hogwarts, new Task("Выучить заклинание", 1, 5))
                .thenAccept(school -> log.info("Школа {} имеет {} очков",
                        school.getName(),
                        school.getTotalPoints()));
        tournament.startTask(durmstrang, new Task("Найти выход из лабиринта", 3, 20))
                .thenAccept(school -> log.info("Школа {} имеет {} очков",
                        school.getName(),
                        school.getTotalPoints()));
        tournament.startTask(hogwarts, new Task("Задержать дыхание под водой", 3, 20))
                .thenAccept(school -> log.info("Школа {} имеет {} очков",
                        school.getName(),
                        school.getTotalPoints()));
        tournament.shutdownCorrectly();
    }
}
