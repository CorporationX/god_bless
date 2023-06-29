package faang.school.godbless.skynet;

import java.util.ArrayList;
import java.util.List;

public class SkyNet {

    public static void main(String[] args) {

        List<Target> targets = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            targets.add(new Target("Target " + i));
        }
        Robot.setBattlefield(targets);

        Robot t800 = new Robot("T-800");
        Robot t1000 = new Robot("T-1000");

        Thread thread1 = new Thread(t800::attack);
        Thread thread2 = new Thread(t1000::attack);

        thread1.start();
        thread2.start();
    }
}
