package faang.school.godbless.BJS2_25133;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Student hermioneGranger = new Student("Hermione Granger", 1995, 75);
        Student ronaldWeasley = new Student("Ronald Weasley", 1994, 70);
        Student harryPotter = new Student("Harry Potter", 1993, 80);
        Student nevilleLongbottom = new Student("Neville Longbottom", 1991, 45);
        School hogwarts = new School("Hogwarts", List.of(hermioneGranger, ronaldWeasley,
                harryPotter, nevilleLongbottom));

        Student fleurDelacour = new Student("Fleur Delacour", 1977, 45);
        Student gabrielleDelacour = new Student("Gabrielle Delacour", 1985, 52);
        Student celineCastillon = new Student("Celine Castillon", 1988, 70);
        Student aurelieDumont = new Student("Aurelie Dumont", 1973, 50);
        School beauxbatons = new School("Beauxbatons", List.of(fleurDelacour, gabrielleDelacour,
                celineCastillon, aurelieDumont));

        Tournament tournament = new Tournament();
        Task task1 = new Task("Kill dragon", 8, 100);
        Task task2 = new Task("Catch all balls", 7, 80);
        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);


        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
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
