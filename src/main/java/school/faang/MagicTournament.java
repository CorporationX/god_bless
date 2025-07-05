package school.faang.bjs2_82905;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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
