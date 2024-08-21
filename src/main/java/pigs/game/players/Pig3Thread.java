package pigs.game.players;

import lombok.NonNull;

public class Pig3Thread extends PigThread {
    public Pig3Thread(@NonNull String pigName, @NonNull String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(800);
            System.out.printf("%s made decent foundation from %s%n", pigName, material);
            Thread.sleep(1000);
            System.out.printf("Reinforced walls from %s! Seems like %s know something about construction%n",
                    material, pigName);
            Thread.sleep(700);
            System.out.printf("%s made very nice roof with slopes. It's very useful when raining%n", pigName);
            System.out.printf("%s finish building! " +
                    "It's very impressive mansion from %s! " +
                    "This house will stand centuries%n", pigName, material);
        } catch (InterruptedException e) {
            throw new RuntimeException("Game crashed");
        }
    }
}
