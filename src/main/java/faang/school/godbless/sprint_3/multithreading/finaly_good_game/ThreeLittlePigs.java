package faang.school.godbless.sprint_3.multithreading.finaly_good_game;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread first = new Pig1Thread();
        PigThread second = new Pig2Thread();
        PigThread third = new Pig3Thread();
        try {
            first.start();
            first.join();
            second.start();
            second.join();
            third.start();
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Game over!");
    }
}
