package faang.school.godbless.magical_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = Arrays.asList(
                new Student("Harry", 10),
                new Student("Germiona", 10),
                new Student("Ron", 11),
                new Student("Malfoy", 10),
                new Student("Dolgopups", 11),
                new Student("Fiona", 9)
        );

        List<Student> beauxbatonsTeam = Arrays.asList(
                new Student("Raian", 12),
                new Student("Atrur", 12),
                new Student("Brain", 10),
                new Student("Locky", 11),
                new Student("Angela", 9),
                new Student("Tor", 8)
        );

        School hogwarts = new School("hogwarts", hogwartsTeam);
        School beauxbatons = new School("beayxbatins", beauxbatonsTeam);

        Task task1 = new Task("Задержка дыхания ", 6, 12);
        Task task2 = new Task("Поймать сквич ", 4, 10);

        //запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTask = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTask.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }
}

@Data
@AllArgsConstructor
class School {
    private String name;
    private List<Student> team;
    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(-1);
    }
}

@Data
class Student {
    private String name;
    private int year;
    private int points = 0;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }
}

@Data
@AllArgsConstructor
class Task {
    private String name;
    private int difficilty;
    private int reward;
}

@Getter
class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1, 8) * 1000L);
                System.out.println("Поток - " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread " + Thread.currentThread().getName() + " прерван");
            }
            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));
            return school;
        });
    }
}