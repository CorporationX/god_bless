package school.faang.bjs2_91311;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread pig1Thread = new Thread(new Pig1Thread("Ниф-Ниф", "клееный брус"));
        Thread pig2Thread = new Thread(new Pig2Thread("Нуф-Нуф", "стекло"));
        Thread pig3Thread = new Thread(new Pig3Thread("Наф-Наф", "газобетонный блок"));

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        pig1Thread.join();
        pig2Thread.join();
        pig3Thread.join();

        System.out.println("Игра завершена!");
    }
}
