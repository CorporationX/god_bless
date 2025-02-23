package school.faang.triwizardtournament;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class App {
    private static final School HOQWARTS = new School("Hogwarts", Arrays.asList(
            new Student("Гарри", 5),
            new Student("Гермиона", 5),
            new Student("Рон", 5)
    ));

    private static final School BEAUXBATONS = new School("Beauxbatons", Arrays.asList(
            new Student("Флар", 5),
            new Student("Олимпия", 5),
            new Student("Аурора", 5)
    ));

    private static final School DURMSTRANG = new School("Durmstrang", Arrays.asList(
            new Student("Виктор", 5),
            new Student("Игорь", 5),
            new Student("Николай", 5)
    ));

    private static final Task FIRST_TASK = new Task("Задание в Запретном Лесу", 2000, 50);
    private static final Task SECOND_TASK = new Task("Поединок с темными силами", 1500, 40);
    private static final Task THIRD_TASK = new Task("Поиск волшебного артефакта", 1000, 30);

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<School> schools = Arrays.asList(HOQWARTS, BEAUXBATONS, DURMSTRANG);
        List<CompletableFuture<School>> futureSchoolList = new ArrayList<>();

        for (School school : schools) {
            CompletableFuture<School> futureSchool = tournament.startTask(school, FIRST_TASK)
                    .thenCompose(s -> tournament.startTask(s, SECOND_TASK))
                    .thenCompose(s -> tournament.startTask(s, THIRD_TASK));
            futureSchoolList.add(futureSchool);
        }

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(
                futureSchoolList.toArray(new CompletableFuture[0])
        );

        allTasks.join();

        School winner = schools
                .stream()
                .max(Comparator.comparingInt(School::getTotalPoints))
                .orElse(null);

        if (winner != null) {
            log.info("Победитель турнира: {} с общим количеством очков: {}",
                    winner.getName(), winner.getTotalPoints());
        } else {
            log.info("Не удалось определить победителя.");
        }
    }
}
