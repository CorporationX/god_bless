package school.faang.bjs2_92999;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Battle battle = new Battle();

        List<Future<Robot>> futuresBattles = List.of(
                battle.fight(
                        new Robot("T1000", 200, 15),
                        new Robot("S1000", 300, 80)),
                battle.fight(
                        new Robot("B1000", 350, 150),
                        new Robot("W1000", 180, 10)),
                battle.fight(
                        new Robot("D1000", 200, 99),
                        new Robot("K1000", 300, 65)),
                battle.fight(
                        new Robot("L1000", 250, 44),
                        new Robot("P1000", 300, 80))
        );
        List<Robot> winners = new ArrayList<>();
        for (Future<Robot> futureWinner : futuresBattles) {
            winners.add(futureWinner.get());
        }
        for (Robot winner : winners) {
            log.info("Победил робот {}!", winner.getName());
        }
    }
}
