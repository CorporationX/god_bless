package faang.school.godbless.FinallyNormalGame;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread pig1 = new Pig1Thread();
        Pig2Thread pig2 = new Pig2Thread();
        Pig3Thread pig3 = new Pig3Thread();

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            Logger.getGlobal().log(Level.SEVERE, "Main thread interrupted", e);
        }

        System.out.println("Game over!");
    }
}
