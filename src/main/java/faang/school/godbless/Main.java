package faang.school.godbless;

public class Main {
    public static void main(String[] args) {

        PigThread pig1 = new Pig1Thread();
        PigThread pig2 = new Pig2Thread();
        PigThread pig3 = new Pig3Thread();

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted.");
        }

        System.out.println("Game Over!");
    }
}