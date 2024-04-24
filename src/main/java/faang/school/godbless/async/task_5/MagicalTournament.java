package faang.school.godbless.async.task_5;

import faang.school.godbless.async.task_5.model.School;
import faang.school.godbless.async.task_5.model.Student;
import faang.school.godbless.async.task_5.model.Task;
import faang.school.godbless.async.task_5.model.Tournament;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        School hogwarts = createHogwartsSchool();
        School beauxbatons = createBeauxbatonsSchool();
        Task easyTask = new Task("easy", 1, 3);
        Task mediumTask = new Task("medium", 4, 6);
        Task hardTask = new Task("hard", 6, 8);
        Task extraHardTask = new Task("extra hard", 9, 10);
        Tournament tournament = new Tournament();
        CompletableFuture<School> hogwartsFirstTask = tournament.startTask(hogwarts, mediumTask);
        CompletableFuture<School> beauxbatonsFirstTask = tournament.startTask(beauxbatons, easyTask);
        CompletableFuture<School> hogwartsSecondTask = tournament.startTask(hogwarts, hardTask);
        CompletableFuture<School> beauxbatonsSecondTask = tournament.startTask(beauxbatons, extraHardTask);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsFirstTask, beauxbatonsFirstTask, hogwartsSecondTask, beauxbatonsSecondTask);
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

    private static School createHogwartsSchool() {
        Student ignat = new Student("ignat", 2, 0, false);
        Student igor = new Student("igor", 2, 0, false);
        return new School("Hogwarts", Arrays.asList(ignat, igor));
    }

    private static School createBeauxbatonsSchool() {
        Student ilona = new Student("ilona", 2, 0, false);
        Student sanya = new Student("sanya", 2, 0, false);
        return new School("Beauxbatons", Arrays.asList(ilona, sanya));
    }
}