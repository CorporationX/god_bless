package faang.school.godbless.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1Thread = new Pig1Thread("Nif-Nif", Material.STRAW);
        Pig2Thread pig2Thread = new Pig2Thread("Naf-Naf", Material.WOOD);
        Pig3Thread pig3Thread = new Pig3Thread("Nuf-Nuf", Material.STONE);

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        pig1Thread.join();
        pig2Thread.join();
        pig3Thread.join();
    }
}
