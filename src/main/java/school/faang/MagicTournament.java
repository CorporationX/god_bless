package school.faang.bjs2_82905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class Student {
    private final String name;
    private final int year;
    private int points;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        this.points = 0;
    }

    public void addPoints(int additionalPoints) {
        this.points += additionalPoints;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}

class School {
    private final String name;
    private final List<Student> team;

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
}

class Task {
    private final String name;
    private final int difficulty;

    public Task(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }
}

class Tournament {

    public CompletableFuture<School> startTask(School school, Task task, Student student, int customReward) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String startMessage = String.format(
                        "Школа '%s | Общие очки: %d' начала задание '%s [Сложность: %d, Награда: %d]' (время: %dмс)",
                        school.getName(),
                        school.getTotalPoints(),
                        task.getName(),
                        task.getDifficulty(),
                        customReward,
                        task.getDifficulty() * 1000
                );
                System.out.println(startMessage);

                TimeUnit.MILLISECONDS.sleep(task.getDifficulty() * 1000L);

                student.addPoints(customReward);

                String completeMessage = String.format(
                        "Школа '%s | Общие очки: %d' выполнила задание! +%d очков студенту %s (Год: %d, Очки: %d)",
                        school.getName(),
                        school.getTotalPoints(),
                        customReward,
                        student.getName(),
                        student.getYear(),
                        student.getPoints()
                );
                System.out.println(completeMessage);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return school;
        });
    }
}

public class MagicTournament {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Создание студентов
        List<Student> hogwartsStudents = Arrays.asList(
                new Student("Гарри Поттер", 5),
                new Student("Гермиона Грейнджер", 5),
                new Student("Рон Уизли", 5)
        );

        List<Student> beauxbatonsStudents = Arrays.asList(
                new Student("Флёр Делакур", 7),
                new Student("Габриэль Делакур", 4),
                new Student("Анри", 6)
        );

        List<Student> durmstrangStudents = Arrays.asList(
                new Student("Виктор Крам", 7),
                new Student("Иван Драгович", 6),
                new Student("Алексей Волков", 5)
        );

        // Создание школ
        School hogwarts = new School("Хогвартс", hogwartsStudents);
        School beauxbatons = new School("Шармбатон", beauxbatonsStudents);
        School durmstrang = new School("Дурмстранг", durmstrangStudents);

        // Создание заданий
        List<Task> tasks = Arrays.asList(
                new Task("Золотое яйцо", 3),
                new Task("Подводное испытание", 5),
                new Task("Лабиринт", 7)
        );

        Tournament tournament = new Tournament();

        List<CompletableFuture<School>> futures = new ArrayList<>();

        // Запуск заданий с разными очками
        futures.add(tournament.startTask(hogwarts, tasks.get(0), hogwartsStudents.get(0), 50));    // Хогвартс +50
        futures.add(tournament.startTask(beauxbatons, tasks.get(0), beauxbatonsStudents.get(0), 50)); // Шармбатон +50
        futures.add(tournament.startTask(durmstrang, tasks.get(0), durmstrangStudents.get(0), 100));  // Дурмстранг +100

        futures.add(tournament.startTask(hogwarts, tasks.get(1), hogwartsStudents.get(1), 100));    // Хогвартс +100
        futures.add(tournament.startTask(beauxbatons, tasks.get(1), beauxbatonsStudents.get(1), 100)); // Шармбатон +100
        futures.add(tournament.startTask(durmstrang, tasks.get(1), durmstrangStudents.get(1), 100));  // Дурмстранг +100

        futures.add(tournament.startTask(hogwarts, tasks.get(2), hogwartsStudents.get(2), 150));    // Хогвартс +150
        futures.add(tournament.startTask(beauxbatons, tasks.get(2), beauxbatonsStudents.get(2), 100)); // Шармбатон +100
        futures.add(tournament.startTask(durmstrang, tasks.get(2), durmstrangStudents.get(2), 150));  // Дурмстранг +150

        // Ожидание выполнения всех заданий и получение результатов
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTasks.get();

        System.out.println("\nВсе задания завершены! Результаты:");

        List<School> schools = Arrays.asList(hogwarts, beauxbatons, durmstrang);

        for (School school : schools) {
            System.out.println(school.getName() + " | Общие очки: " + school.getTotalPoints());
        }

        School winner = schools.stream()
                .max(Comparator.comparingInt(School::getTotalPoints))
                .orElse(null);

        System.out.println("\nПобедитель турнира: " + winner.getName() + " | Общие очки: " + winner.getTotalPoints());
    }
}
