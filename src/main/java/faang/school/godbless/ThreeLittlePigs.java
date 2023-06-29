package faang.school.godbless;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        PigThread pig1Thread = new PigThread("Niff-Niff", 1);
        PigThread pig2Thread = new PigThread("Nuff-Nuff", 2);
        PigThread pig3Thread = new PigThread("Naff-Naff", 3);

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        pig1Thread.join();
        pig2Thread.join();
        pig3Thread.join();

        System.out.println("Game over!");
    }
}
