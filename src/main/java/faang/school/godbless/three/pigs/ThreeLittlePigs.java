package faang.school.godbless.three.pigs;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1Thread = new Pig1Thread("���-���", 10);
        Pig2Thread pig2Thread = new Pig2Thread("���-���", 40);
        Pig3Thread pig3Thread = new Pig3Thread("���-���", 60);

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        pig1Thread.join();
        pig2Thread.join();
        pig3Thread.join();
    }
}
