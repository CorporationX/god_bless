package BJS2_23420_Finally_normal_game;

public class ThreeLittlePig {

    public static void main(String[] args) throws InterruptedException {

        var thread = new Pig1Thread();
        var thread1 = new Pig2Thread();
        var thread2 = new Pig3Thread();

        thread.start();
        thread1.start();
        thread2.start();
        thread.join();
        thread1.join();
        thread2.join();
        thread2.gameOver();
    }
}