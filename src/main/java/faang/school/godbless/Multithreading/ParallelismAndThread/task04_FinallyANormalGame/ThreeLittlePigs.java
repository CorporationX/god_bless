package faang.school.godbless.Multithreading.ParallelismAndThread.task04_FinallyANormalGame;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread pig1Thread = new Pig1Thread("nafNaf", "straw");
        PigThread pig2Thread = new Pig2Thread("nufNuf", "sticks");
        PigThread pig3Thread = new Pig3Thread("nifNif", "bricks");

        try {
            pig1Thread.start();
            pig2Thread.start();
            pig3Thread.start();
            pig1Thread.join();
            pig2Thread.join();
            pig3Thread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
