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
        PigThread pigNif = new PigThread("Nif-Nif", "Straw");
        PigThread pigNuf = new PigThread("Nuf-Nuf", "Sticks");
        PigThread pigNaf = new PigThread("Naf-Naf", "Bricks");
        return List.of(pigNif, pigNuf, pigNaf);
    }
}
