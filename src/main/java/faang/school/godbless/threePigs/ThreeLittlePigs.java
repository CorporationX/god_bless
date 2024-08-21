package faang.school.godbless.threePigs;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread p1 = new Pig1Thread();
        Pig2Thread p2 = new Pig2Thread();
        Pig3Thread p3 = new Pig3Thread();

        p1.start();
        p2.start();
        p3.start();

        p1.join();
        p2.join();
        p3.join();

        System.out.println("The game is over!");
    }
}
