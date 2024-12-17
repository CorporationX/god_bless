package school.faang.task_46190;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Droid droidA = new Droid("R2D2");
        Droid droidB = new Droid("R2D2");

        droidA.sendMessage(droidB, "Let's check your programs", 1);
        droidB.sendMessage(droidA, "No", 2);
    }
}
