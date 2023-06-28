package faang.school.godbless.finallyGoodGame;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread thread1 = new Pig1Thread();
        Pig2Thread thread2 = new Pig2Thread();
        Pig3Thread thread3 = new Pig3Thread();

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The end");
    }
}
