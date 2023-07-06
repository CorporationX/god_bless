package faang.school.godbless.Sprint4.Task_4_GoodGame;

public class ThreeLittlePigs {
    public static void main(String[] args) {

        PigThread pig1Thread = new Pig1Thread();
        PigThread pig2Thread = new Pig2Thread();
        PigThread pig3Thread = new Pig3Thread();

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        try {
            pig1Thread.join();
            pig2Thread.join();
            pig3Thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("игра завершена!");
    }
}
