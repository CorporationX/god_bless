package faang.school.godbless.FinallyNormalGame;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Nuf nuf", 2);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " is building a house out of sticks");
            Thread.sleep(3000);
            System.out.println(getPigName() + " built a house out of sticks!");
        } catch (InterruptedException e) {
            Logger.getGlobal().log(Level.SEVERE, "Exception occurred for pig: " + getPigName(), e);
        }
    }
}
