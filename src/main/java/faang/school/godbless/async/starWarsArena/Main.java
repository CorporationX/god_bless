package faang.school.godbless.async.starWarsArena;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Droid r2d2 = new Droid("R2-D2", 5, 13);
        Droid c3po = new Droid("C-3PO", 4, 15);

        Future<Droid> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Droid winner = winnerFuture.get();
            log.info("Победитель битвы: " + winner.name());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.endFights();
    }
}
