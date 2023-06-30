package faang.school.godbless.task.goodgame;

import java.util.ArrayList;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<Thread> pigs = new ArrayList<>(List.of(
                new Pig3Thread("nufnuf"),
                new Pig2Thread("nafnaf"),
                new Pig1Thread("nifnif")
        ));

        for (var pig : pigs) {
            pig.start();
        }

        for (var pig : pigs) {
            try {
                pig.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All pigs have built their houses!");
    }
}
