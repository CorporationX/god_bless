package faang.school.godbless.game;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1Thread = new Pig1Thread();
        Pig2Thread pig2Thread = new Pig2Thread();
        Pig3Thread pig3Thread = new Pig3Thread();

        Thread threadPig1 = new Thread(pig1Thread);
        Thread threadPig2 = new Thread(pig2Thread);
        Thread threadPig3 = new Thread(pig3Thread);

        threadPig1.start();
        threadPig2.start();
        threadPig3.start();
        threadPig1.join();
        threadPig2.join();
        threadPig3.join();
        System.out.println("Игра завершена!");
    }
}
