package school.faang.blockingsptifybjs49377;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        final Thread thread1 = new Thread(() -> player.play());
        final Thread thread2 = new Thread(() -> player.pause());
        final Thread thread3 = new Thread(() -> player.skip());
        final Thread thread4 = new Thread(() -> player.previous());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All action completed");
    }
}
