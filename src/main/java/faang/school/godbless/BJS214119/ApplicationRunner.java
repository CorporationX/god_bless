package faang.school.godbless.BJS214119;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ApplicationRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Battle battle = new Battle();

        List<Future<Robot>> futureWinners = new ArrayList<>(List.of(
                battle.fight(new Robot("R2-D2", 5, 7), new Robot("C-3PO", 4, 8)),
                battle.fight(new Robot("R3-D3", 5, 7), new Robot("C-4PO", 4, 8)),
                battle.fight(new Robot("R4-D4", 5, 7), new Robot("C-5PO", 4, 8))
        ));
        battle.shutdown();

        waitWinners(futureWinners);
    }

    private static void waitWinners(List<Future<Robot>> futureWinners) throws ExecutionException, InterruptedException {
            while (!futureWinners.isEmpty()) {
                for (int i = 0; i < futureWinners.size(); i++) {
                    var futureWinner = futureWinners.get(i);
                    if (futureWinner.isDone()) {
                        Robot winner = futureWinner.get();
                        System.out.println("Победитель битвы: " + winner.name());
                        futureWinners.remove(i);
                    }
                }
            }
    }

}
