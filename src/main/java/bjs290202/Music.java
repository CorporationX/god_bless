package bjs290202;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread thread1 = new Thread(player::play);
        thread1.start();

        Thread thread2 = new Thread(player::skip);
        thread2.start();

        Thread thread3 = new Thread(player::previous);
        thread3.start();

        Thread thread4 = new Thread(player::pause);
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}

