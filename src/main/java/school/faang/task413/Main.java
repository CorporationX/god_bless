package school.faang.task413;

import school.faang.task413.hogwarts.School;
import school.faang.task413.hogwarts.Student;
import school.faang.task413.hogwarts.Task;
import school.faang.task413.hogwarts.Tournament;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        School hogwarts = new School("Хогвартс");
        School durmstrang = new School("Думстранг");
        School uagadol = new School("Уагадол");

        Stream.of(hogwarts, durmstrang, uagadol).forEach(school -> {
            for (int i = 0; i < 3; i++) {
                school.addStudent(new Student("name " + i + " из школы " + school.getName(), new Random().nextInt(4), 0));
            }
        });

        Task firstTask = new Task("Лабиринт", 12, 200);
        Task secondTask = new Task("Поединок с драконами", 9, 150);
        Task thirdTask = new Task("Плаванье", 5, 120);

        Tournament tournament = new Tournament();

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, firstTask);
        CompletableFuture<School> durmstrangTask = tournament.startTask(durmstrang, secondTask);
        CompletableFuture<School> uagadolTask = tournament.startTask(uagadol, thirdTask);

        CompletableFuture<Void> allTask = CompletableFuture.allOf(hogwartsTask, durmstrangTask, uagadolTask);
        allTask.join();

        Stream.of(hogwarts, durmstrang, uagadol)
                .sorted(Comparator.comparingInt(School::getTotalPoints).reversed())
                .limit(1)
                .peek(school -> System.out.println("Школа " + school.getName() + " побеждает!"))
                .toList();
    }
}
