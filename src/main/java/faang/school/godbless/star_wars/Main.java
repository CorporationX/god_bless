package faang.school.godbless.star_wars;

import lombok.SneakyThrows;
import java.util.concurrent.Future;

public class Main {
    @SneakyThrows  //try and catch alternative and throws Execution and Interrupted exceptions

    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot r2d2 = new Robot("R2-D2", 10, 15);
        Robot c2po = new Robot("C2-PO", 8, 12);

        Future<Robot> winnerFuture = battle.fight(r2d2, c2po);

        Robot winner = winnerFuture.get();
        System.out.println("Winner of the battle " + winner.getName());
    }
}
