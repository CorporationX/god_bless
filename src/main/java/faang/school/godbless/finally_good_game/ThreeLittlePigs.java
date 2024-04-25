package faang.school.godbless.finally_good_game;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread pig1Thread = new Pig1Thread("Ниф-Ниф", 1);
        Pig2Thread pig2Thread = new Pig2Thread("Нуф-Нуф", 2);
        Pig3Thread pig3Thread = new Pig3Thread("Наф-Наф", 3);
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

        System.out.println("Game is over!");
    }
}