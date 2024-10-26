package school.faang.triwizardtournament;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MyTournament {
    public static void main(String[] args) {
        School schoolOne = new School("Hogwards", Arrays.asList(new Student("Evgen", 1978, 500),
                new Student("Paha", 2005, 345), new Student("Olya", 1995, 300)));
        School schoolTwo = new School("Gimnaz", Arrays.asList(new Student("Dima", 1995, 340),
                new Student("Uljyana", 2000, 650), new Student("Lena", 2005, 750)));
        Task taskOne = new Task("Proga", 3, 600);
        Task taskTwo = new Task("Fire", 3, 900);
        Tournament tournament = new Tournament();
        CompletableFuture<School> future = tournament.startTask(schoolOne, taskOne);
        System.out.println(future.join().getTotalPoints());
    }
}
