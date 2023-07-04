package faang.school.godbless.normal_game;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> pigThreads = createPigsThreads();

        for (PigThread pigThread : pigThreads) {
            pigThread.start();
        }
        for (PigThread pigThread : pigThreads) {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Game over");
    }

    private static List<PigThread> createPigsThreads() {
        Pig1Thread pigNif = new Pig1Thread("Nif-Nif", "Straw");
        Pig2Thread pigNuf = new Pig2Thread("Nuf-Nuf", "Sticks");
        Pig3Thread pigNaf = new Pig3Thread("Naf-Naf", "Bricks");
        return List.of(pigNif, pigNuf, pigNaf);
    }
}
