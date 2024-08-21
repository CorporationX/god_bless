package pigs.game.players;

import lombok.NonNull;

public class Pig2Thread extends PigThread {
    public Pig2Thread(@NonNull String pigName, @NonNull String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(400);
            System.out.printf("%s digged %s in earth%n", pigName, material);
            Thread.sleep(400);
            System.out.printf("%s made walls with %s%n", pigName, material);
            Thread.sleep(400);
            System.out.printf("%s done with roof%n", pigName);
            System.out.printf("%s finish building! " +
                    "He has some pretty house made from %s! " +
                    "But it definitely can't protect him from the storm that coming...%n", pigName, material);
        } catch (InterruptedException e) {
            throw new RuntimeException("Game crashed");
        }
    }
}
