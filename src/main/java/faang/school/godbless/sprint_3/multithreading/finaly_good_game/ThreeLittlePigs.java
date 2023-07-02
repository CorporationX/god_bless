package faang.school.godbless.sprint_3.multithreading.finaly_good_game;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread first = new Pig1Thread("Ниф-Ниф", 1);
        PigThread second = new Pig2Thread("Нуф-Нуф", 2);
        PigThread third = new Pig3Thread("Наф-Наф", 3);
        try {
            first.start();
            second.start();
            third.start();
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Game over!");
    }
}
