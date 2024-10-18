package school.faang.finaly_ok_game_BJS2_36341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {

        List<PigThread> pigs = new ArrayList<>(Arrays.asList(
                new PigThread1("nif-nif", "straw"),
                new PigThread2("naf-naf", "sticks"),
                new PigThread3("nuf-nuf", "bricks")));

        for (PigThread pig : pigs) {
            pig.start();
        }

        for (PigThread pig : pigs) {
            try {
                pig.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        System.out.println("Game finished");
    }
}
