package faang.school.godbless.piglets;

import java.util.List;

public class ThreeLittlePigs {

    public static void main(String[] args) {
        List.of(new Pig1Thread(), new Pig2Thread(), new Pig3Thread())
            .forEach(pigThread -> {
                pigThread.start();
                try {
                    pigThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        System.out.println("Game over!");
    }
}
