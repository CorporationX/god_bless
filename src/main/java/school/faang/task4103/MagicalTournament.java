package school.faang.task4103;

import java.util.List;
import java.util.concurrent.*;

class Student {
    private String name;
    private int year;
    private int points;

    public Student(String name, int year, int points) {
        this.name = name;
        this.year = year;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}

class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(int points) {
        team.forEach(student -> student.addPoints(points / team.size()));
    }
}

class Task {
    private String name;
    private int difficulty;
    private int reward;

    public Task(String name, int difficulty, int reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getReward() {
        return reward;
    }
}

class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(school.getName() + " is starting task: " + task.getName());
                Thread.sleep(task.getDifficulty() * 1_000L);
                school.addPointsToTeam(task.getReward());
                System.out.println(school.getName() + " has completed task: " + task.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            return school;
        });
    }
}

public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Creating schools
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Creating tasks
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        // Starting tasks for schools
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            try {
                // Getting results
                School hogwartsResult = hogwartsTask.get();
                School beauxbatonsResult = beauxbatonsTask.get();

                // Determining the winner
                if (hogwartsResult.getTotalPoints() > beauxbatonsResult.getTotalPoints()) {
                    System.out.println(hogwartsResult.getName() + " wins the tournament with " + hogwartsResult.getTotalPoints() + " points!");
                } else if (beauxbatonsResult.getTotalPoints() > hogwartsResult.getTotalPoints()) {
                    System.out.println(beauxbatonsResult.getName() + " wins the tournament with " + beauxbatonsResult.getTotalPoints() + " points!");
                } else {
                    System.out.println("The tournament ends in a draw with both schools having " + hogwartsResult.getTotalPoints() + " points!");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).join();
    }
}
