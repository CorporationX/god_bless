package faang.school.godbless.Supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SuperCow {
    public static void main(String[] args) throws InterruptedException {

        Boss boss = new Boss(2);

        List<Player> playerList = List.of(new Player("Nagibator_1337"),
                new Player("123_Gosha_123"),
                new Player("XY...SOS..."),
                new Player("OduVanchik"));

        ExecutorService executor = Executors.newCachedThreadPool();

    }
}
