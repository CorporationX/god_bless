package Sprint_4_Task4;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1Thread = new Pig1Thread();
        Pig2Thread pig2Thread = new Pig2Thread();
        Pig3Thread pig3Thread = new Pig3Thread();
        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();
        pig1Thread.join();
        pig2Thread.join();
        pig3Thread.join();
        System.out.println("Игра завершена!");
    }
}
