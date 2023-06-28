package faang.school.godbless.normal_game;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread pig1Thread = new Pig1Thread("pig1");
        pig1Thread.start();
        Pig2Thread pig2Thread = new Pig2Thread("pig2");
        pig2Thread.start();
        Pig3Thread pig3Thread = new Pig3Thread("pig3");
        pig3Thread.start();

        try {
            pig1Thread.join();
            pig2Thread.join();
            pig3Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Construction finished");
    }
}
