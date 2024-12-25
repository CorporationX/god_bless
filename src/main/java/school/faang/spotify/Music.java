package school.faang.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread thread1 = new Thread(player::play);
        thread1.start();
        Thread thread2 = new Thread(player::pause);
        thread2.start();
        Thread thread3 = new Thread(player::play);
        thread3.start();
        Thread thread4 = new Thread(player::skip);
        thread4.start();
        Thread thread5 = new Thread(player::previous);
        thread5.start();
        Thread thread6 = new Thread(player::play);
        thread6.start();

    }
}