package faang.school.godbless.normal_game;

public class Main {
    public static void main(String[] args) {
        Pig1Thread pig1Thread = new Pig1Thread("Nif-Nif", 15);
        Pig2Thread pig2Thread = new Pig2Thread("Naf-Naf", 25);
        Pig3Thread pig3Thread = new Pig3Thread("Nuf-Nuf", 35);

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        waitConstruction(pig1Thread);
        waitConstruction(pig2Thread);
        waitConstruction(pig3Thread);

        System.out.println("The House construction is finished!");
    }

    private static void waitConstruction(PigThread pigThread) {
        try {
            pigThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("The Wolf came earlier than the Pigs constructed their houses");
        }
    }
}
