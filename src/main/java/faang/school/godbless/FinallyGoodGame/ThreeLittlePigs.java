package faang.school.godbless.FinallyGoodGame;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<PigThread> threads = getPigThreads();
        for (PigThread thread : threads) {
            thread.start();
            thread.join();
        }
        System.out.println("Game is over");
    }

    private static List<PigThread> getPigThreads() {
        PigThread thread1 = new Pig1Thread("NifNif");
        PigThread thread2 = new Pig2Thread("NafNaf");
        PigThread thread3 = new Pig3Thread("NufNuf");
        List<PigThread> threads = List.of(thread1, thread2, thread3);
        return threads;
    }
}
