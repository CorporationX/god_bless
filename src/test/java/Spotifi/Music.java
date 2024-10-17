package Spotifi;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread1 = new Thread(() -> {
            player.play();
            System.out.println(Thread.currentThread().getName());
        });
        Thread playThread2 = new Thread(() -> {
            player.play();
            System.out.println(Thread.currentThread().getName());
        });
        Thread playThread3 = new Thread(() -> {
            player.play();
            System.out.println(Thread.currentThread().getName());
        });
        Thread pauseThread1 = new Thread(() -> {
            player.pause();
            System.out.println(Thread.currentThread().getName());
        });
        Thread pauseThread2 = new Thread(() -> {
            player.pause();
            System.out.println(Thread.currentThread().getName());
        });
        Thread pauseThread3 = new Thread(() -> {
            player.pause();
            System.out.println(Thread.currentThread().getName());
        });
        Thread skipThread1 = new Thread(() -> {
            player.skip();
            System.out.println(Thread.currentThread().getName());
        });
        Thread skipThread2 = new Thread(() -> {
            player.skip();
            System.out.println(Thread.currentThread().getName());
        });
        Thread previousThread1 = new Thread(() -> {
            player.previous();
            System.out.println(Thread.currentThread().getName());
        });
        Thread previousThread2 = new Thread(() -> {
            player.previous();
            System.out.println(Thread.currentThread().getName());
        });

        playThread1.start();
        playThread2.start();
        playThread3.start();
        pauseThread1.start();
        pauseThread2.start();
        pauseThread3.start();
        skipThread1.start();
        skipThread2.start();
        previousThread1.start();
        previousThread2.start();

    }
}
