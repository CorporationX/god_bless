package faang.school.godbless.bjs2_5582;

public class ThreeLittlePigs {

    public static void main(String[] args) {

        PigThread pigThread1 = new Pig1Thread("Ниф-Ниф", "солома");
        PigThread pigThread2 = new Pig2Thread("Нуф-Нуф", "палки");
        PigThread pigThread3 = new Pig3Thread("Наф-Наф", "кирпич");

        System.out.println("Start game");

        pigThread1.start();
        pigThread2.start();
        pigThread3.start();

        try {
            pigThread1.join();
            pigThread2.join();
            pigThread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Game over!");
    }
}
