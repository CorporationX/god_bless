package school.faang.play;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1Thread = new Pig1Thread("pig1", "солома");
        Pig1Thread pig2Thread = new Pig1Thread("pig2", "кирпич");
        Pig1Thread pig3Thread = new Pig1Thread("pig3", "ветки");

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        pig1Thread.join();
        pig2Thread.join();
        pig3Thread.join();

        System.out.println("Игра завершена!");
    }
}
