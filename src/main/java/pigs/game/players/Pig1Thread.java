package pigs.game.players;

import lombok.NonNull;

public class Pig1Thread extends PigThread {
    public Pig1Thread(@NonNull String pigName, @NonNull String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(500);
            System.out.printf("%s finish building! His \"house\" just a hut made of tied %s!%n", pigName, material);
        } catch (InterruptedException e) {
            throw new RuntimeException("Game crashed");
        }
    }
}
