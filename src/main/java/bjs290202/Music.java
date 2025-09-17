package bjs290202;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        Thread thread1 = new Thread(player::play);
        Thread thread2 = new Thread(player::skip);
        Thread thread3 = new Thread(player::previous);
        Thread thread4 = new Thread(player::pause);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}

