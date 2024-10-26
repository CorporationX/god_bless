package school.faang.triwizardtournament;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class MyTournament {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        School schoolOne = new School("Hogwards", Arrays.asList(new Student("Evgen", 1978, 500),
                new Student("Paha", 2005, 345), new Student("Olya", 1995, 300)));
        School schoolTwo = new School("Gimnaz", Arrays.asList(new Student("Dima", 1995, 340),
                new Student("Uljyana", 2000, 650), new Student("Lena", 2005, 750)));
        Task taskOne = new Task("Proga", 3, 600);
        Task taskTwo = new Task("Fire", 3, 900);
        Tournament tournament = new Tournament();
        CompletableFuture<School> future1 = tournament.startTask(schoolOne, taskOne, service);
        CompletableFuture<School> future2 = tournament.startTask(schoolTwo, taskTwo, service);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);
        CompletableFuture<List<School>> joinResultSchools = allOf.thenApply(res -> Stream.of(future1, future2).map(CompletableFuture::join)
                .toList());
        List<School> resultSchools = joinResultSchools.get();
        Optional<School> winnerOptional = resultSchools.stream()
                        .max(Comparator.comparingInt(School::getTotalPoints));
        if (winnerOptional.isPresent()) {
            School winner = winnerOptional.get();
            System.out.println("Победила школа " + winner.getName() + ". Набрав " + winner.getTotalPoints() + " очков!");
        }
        resultSchools.stream()
                        .map(School::getTotalPoints)
                                .forEach(System.out::println);
        service.shutdown();
    }
}
