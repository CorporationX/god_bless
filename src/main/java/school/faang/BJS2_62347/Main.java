package school.faang.BJS2_62347;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Student> gryffindor = new ArrayList<>();
        gryffindor.add(new Student("Гарри", 2, 0));
        gryffindor.add(new Student("Петр", 2, 0));
        School hogwarts = new School("Hogwarts", gryffindor);

        List<Student> slytherin = new ArrayList<>();
        slytherin.add(new Student("Гоил", 2, 0));
        slytherin.add(new Student("Федя", 2, 0));
        School harvard = new School("Harvard", slytherin);

        Task task1 = new Task("Турнир волшебников", 10, 100);
        Task task2 = new Task("Турнир защиты от магии", 5, 50);

        Tournament tournament = new Tournament();
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> harvardTask = tournament.startTask(harvard, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, harvardTask);
        allTasks.thenRun(() -> {

            int hogwartsPoints = hogwarts.getTotalPoints();
            log.debug("всего очков у {} {}", hogwarts.getName(), hogwartsPoints);
            int harvardPoints = harvard.getTotalPoints();
            log.debug("всего очков у {} {}", harvard.getName(), harvardPoints);

            if (hogwartsPoints > harvardPoints) {
                System.out.println("Школа Хогвардс выйграла турнир!");
            } else if (harvardPoints > hogwartsPoints) {
                System.out.println("Школа Гарварда выйграла турнир!");
            } else {
                System.out.println("Ничия");
            }
        }).join();
    }
}