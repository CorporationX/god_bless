package school.faang.bjs2_74883;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void doTasksForTourney(Tournament tourney,
                                         List<CompletableFuture<School>> futuresForFirst,
                                         List<CompletableFuture<School>> futuresForSecond,
                                         School firstschool,
                                         School secondschool) {
        for (Task task : tourney.getTasks()) {
            futuresForFirst.add(tourney.startTask(firstschool, task));
            futuresForSecond.add(tourney.startTask(secondschool, task));
        }
    }

    public static void main(String[] args) {
        List<Student> krak = List.of(
                new Student("Dude", 1, 1),
                new Student("Viet", 2, 0),
                new Student("Thin", 3, 0)
        );
        List<Student> kelp = List.of(
                new Student("Nick", 1, 0),
                new Student("Mar", 2, 0),
                new Student("Bot", 3, 0)
        );

        School hog = new School("Hog", krak);
        School bulg = new School("Bulg", kelp);

        Task catchFrogs = new Task(2, "Catch Frogs", Difficulty.HARD);
        Task killDragon = new Task(3, "Kill dragon", Difficulty.EASY);
        Task study = new Task(3, "Study", Difficulty.MEDIUM);
        List<Task> tasks1 = List.of(catchFrogs, killDragon, study);

        Task runAway = new Task(1, "Run Away", Difficulty.EASY);
        Task paintWarhammer = new Task(3, "Paint warhammer", Difficulty.HARD);
        Task sleep = new Task(2, "Sleep", Difficulty.MEDIUM);
        List<Task> tasks2 = List.of(runAway, paintWarhammer, sleep);

        Tournament worldCup = new Tournament(tasks1);
        Tournament threeDudesTourney = new Tournament(tasks2);
        List<CompletableFuture<School>> futuresOfThreeDudesForHog = new ArrayList<>();
        List<CompletableFuture<School>> futuresOfThreeDudesForBulg = new ArrayList<>();
        List<CompletableFuture<School>> futuresOfWorldCupForHog = new ArrayList<>();
        List<CompletableFuture<School>> futuresOfWorldCupForBulg = new ArrayList<>();

        doTasksForTourney(worldCup, futuresOfWorldCupForHog, futuresOfWorldCupForBulg, hog, bulg);
        doTasksForTourney(threeDudesTourney, futuresOfThreeDudesForHog, futuresOfThreeDudesForBulg, hog, bulg);

        CompletableFuture.allOf(futuresOfThreeDudesForHog.toArray(new CompletableFuture[0])).join();
        CompletableFuture.allOf(futuresOfThreeDudesForBulg.toArray(new CompletableFuture[0])).join();

        CompletableFuture.allOf(futuresOfWorldCupForHog.toArray(new CompletableFuture[0])).join();
        CompletableFuture.allOf(futuresOfWorldCupForBulg.toArray(new CompletableFuture[0])).join();

        if (bulg.getTotalPoints() < hog.getTotalPoints()) {
            System.out.println("Hog wins");
        } else if (hog.getTotalPoints() < bulg.getTotalPoints()) {
            System.out.println("Bulg wins");
        } else if (hog.getTotalPoints() == bulg.getTotalPoints()) {
            System.out.println("Ended up as draw");
        }

        worldCup.getExecutor().shutdown();
        threeDudesTourney.getExecutor().shutdown();
    }
}
