package school.faang.task_50976;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsMan = new ArrayList<>();
        List<Student> studentsWomen = new ArrayList<>();
        studentsMan.add(new Student("Павел", 5, 0));
        studentsMan.add(new Student("Алексей", 5, 0));
        studentsMan.add(new Student("Владимир", 5, 0));
        studentsMan.add(new Student("Виктор", 5, 0));
        studentsMan.add(new Student("Николай", 5, 0));

        studentsWomen.add(new Student("Маша", 4, 0));
        studentsWomen.add(new Student("Катя", 4, 0));
        studentsWomen.add(new Student("Юля", 4, 0));
        studentsWomen.add(new Student("Света", 4, 0));
        studentsWomen.add(new Student("Аня", 4, 0));

        School schoolMan = new School("Школа мальчиков", studentsMan);
        School schoolWoman = new School("Школа девочек", studentsWomen);

        Task task1 = new Task("Украсить волшебную елку", 5, 10);
        Task task2 = new Task("Помочь Санте подарить подарки", 4, 12);

        Tournament tournament = new Tournament();

        CompletableFuture<School> spruce = tournament.startTask(schoolMan, task1);

        CompletableFuture<School> santa = tournament.startTask(schoolWoman, task2);
        while (!santa.isDone() || spruce.isDone()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Tournament.LOGGER.error("Ошибка ожидания потока, {}", e.getMessage());
            }
        }

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(spruce, santa);
        allTasks.thenRun(() -> {
            if (schoolMan.getTotalPoints() > schoolWoman.getTotalPoints()) {
                Tournament.LOGGER.debug("команда {} выиграла турнир", schoolMan.getName());
            } else {
                Tournament.LOGGER.debug("команда {} выиграла турнир", schoolWoman.getName());
            }
        });
    }
}
