package faang.school.godbless.three.pigs;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1Thread = new Pig1Thread("Ниф-Ниф", 2);
        Pig2Thread pig2Thread = new Pig2Thread("Нуф-Нуф", 4);
        Pig3Thread pig3Thread = new Pig3Thread("Наф-Наф", 5);

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        pig1Thread.join();
        pig2Thread.join();
        pig3Thread.join();

        System.out.println("дома построены");
    }
}
