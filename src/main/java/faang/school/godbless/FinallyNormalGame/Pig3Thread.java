package faang.school.godbless.FinallyNormalGame;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Naf naf", 3);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " is building a house out of bricks");
            Thread.sleep(4000);
            System.out.println(getPigName() + " built a house out of bricks!");
        } catch (InterruptedException e) {
            Logger.getGlobal().log(Level.SEVERE, "Exception occurred for pig: " + getPigName(), e);
        }
    }
}
