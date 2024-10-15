package school.faang.normalgame;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread pig1Thread = new Pig1Thread();
        Pig2Thread pig2Thread = new Pig2Thread();
        Pig3Thread pig3Thread = new Pig3Thread();

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
        System.out.println("Вот и поиграли");
    }
}
