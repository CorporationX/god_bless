package faang.school.godbless.multithreading.finally_normal_game;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> pigThreads = List.of(new Pig1Thread(), new Pig2Thread(), new Pig3Thread());
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
        System.out.println("Game over!");
    }
}
