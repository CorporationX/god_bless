package faang.school.godbless.normal_game;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1 = new Pig1Thread("Nif-Nif", 0);
        Pig1Thread pig2 = new Pig1Thread("Naf-Naf", 1);
        Pig1Thread pig3 = new Pig1Thread("Nuf-Nuf", 2);
        pig1.start();
        pig2.start();
        pig3.start();
        pig1.join();
        pig2.join();
        pig3.join();
        System.out.println("Все дома построены!");
    }
}
