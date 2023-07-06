package finally_good_game;

import java.util.Arrays;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread[] pigs = {
                new PigThread("nif nif", "straw",2000),
        new PigThread("naf naf", "sticks", 3000),
        new PigThread("nuf nuf", "bricks", 4000)
        };

        for (PigThread pig : pigs) {
            pig.start();
        }

        Arrays.stream(pigs).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Pigs built all house successfully");
    }
}
