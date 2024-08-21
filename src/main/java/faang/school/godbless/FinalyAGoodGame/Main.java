package faang.school.godbless.FinalyAGoodGame;

public class Main {
    public static void main(String[] args) {
        Pig1Thread pig1Thread = new Pig1Thread("nif-nif", 1);
        Pig2Thread pig2Thread = new Pig2Thread("nuf-nuf", 2);
        Pig3Thread pig3Thread = new Pig3Thread("naf-naf", 3);
        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();
        try {
            pig1Thread.join();
            pig2Thread.join();
            pig3Thread.join();
        } catch (InterruptedException e) {
            System.out.println("дом загриферили(");
            throw new RuntimeException(e);
        }
        System.out.println("игра завершена!");
    }
}
