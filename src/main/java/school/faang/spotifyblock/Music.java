package school.faang.spotifyblock;

public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        Thread thread1 = new Thread(() -> player.play(), "User 1");
        Thread thread2 = new Thread(() -> player.pause(), "User 2");
        Thread thread3 = new Thread(() -> player.skip(), "User 3");
        Thread thread4 = new Thread(() -> player.previous(), "User 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        player.ge
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final state: " + player.getIsPlaying());

    }
}
