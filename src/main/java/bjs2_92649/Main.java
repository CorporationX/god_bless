package bjs2_92649;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        List<Robot> robots = List.of(
                new Robot("R2-D2", 5, 7),
                new Robot("C-3PO", 4, 8),
                new Robot("BB-8", 6, 6),
                new Robot("IG-88", 8, 5)
        );

        IntStream.range(0, robots.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, robots.size())
                        .mapToObj(j -> battle.fight(robots.get(i), robots.get(j))))
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(winner -> System.out.printf("Победитель: %s%n%n", winner.getName()));

        battle.shutdown();
    }
}