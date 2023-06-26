package faang.school.godbless.FinallyNormalGame;

import java.util.Random;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Наф-наф", "Дерево");
    }

    @Override
    public void run() {
        try {
            System.out.println("House is building...");
            Thread.sleep(new Random().nextInt(1000, 2000));
            System.out.println("House of " + this.getMaterial() + " was build");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
