package faang.school.godbless.FinallyNormalGame;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Nif nif", 1);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " is building a house out of straw");
            Thread.sleep(2000);
            System.out.println(getPigName() + " built a house out of straw!");
        } catch (InterruptedException e) {
            Logger.getGlobal().log(Level.SEVERE, "Exception occurred for pig: " + getPigName(), e);
        }
    }
}
