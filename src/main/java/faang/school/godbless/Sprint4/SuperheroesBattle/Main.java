package faang.school.godbless.Sprint4.SuperheroesBattle;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    static List<Superhero> superheroList = new LinkedList<>();
    private static int round = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        // Создание супергероев
        superheroList.add(new Superhero("Iron Man", 9, 6, 100));
        superheroList.add(new Superhero("Captain America", 8, 8, 150));
        superheroList.add(new Superhero("Thor", 10, 7, 200));
        superheroList.add(new Superhero("Hulk", 10, 4, 300));
        superheroList.add(new Superhero("Spider Man", 6, 10, 150));

        if (superheroList.size() % 2 != 0) {
            superheroList.add(new Superhero("LuckyTicket", 0, 0, 0));
        }

        CompletableFuture fighter = null;
        while (superheroList.size() != 1) {
            System.out.printf("|--------------|\nround - %d\n|--------------|\n", ++round);
            System.out.println("List of superheroes" + superheroList.toString());
            for (int i = 0; i < superheroList.size() / 2; i++) {
                int finalI = i;
                fighter = CompletableFuture.supplyAsync(
                                () -> superheroBattle.runCompetitions(superheroList.get(finalI), superheroList.get(superheroList.size() - 1 - finalI)))
                        .thenAccept(x -> superheroList.remove(x));
            }
            fighter.get(10, TimeUnit.SECONDS);
        }

        System.out.println("| New absolute winner is - " + superheroList.get(0).getName()+" |");
    }
}
