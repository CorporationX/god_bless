package faang.school.godbless.normalGame;

public class App {
    public static void main(String[] args) {
        PigThread pig1 = new Pig1Thread("Nif-Nif", 1);
        PigThread pig2 = new Pig2Thread("Nuf-Nuf", 2);
        PigThread pig3 = new Pig3Thread("Naf-Naf", 3);

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Game over!");
    }
}
