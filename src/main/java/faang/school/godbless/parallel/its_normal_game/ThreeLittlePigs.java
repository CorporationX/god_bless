package faang.school.godbless.parallel.its_normal_game;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread first = new Pig1Thread();
        PigThread second = new Pig2Thread();
        PigThread third = new Pig3Thread();
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

