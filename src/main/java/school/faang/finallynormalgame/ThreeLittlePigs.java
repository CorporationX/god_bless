package school.faang.finallynormalgame;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread pig1 = new Pig1Thread("Nif-Nif", "straw");
        PigThread pig2 = new Pig2Thread("Nuf-Nuf", "sticks");
        PigThread pig3 = new Pig3Thread("Naf-Naf", "bricks");

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("The game is over!");
    }
}

