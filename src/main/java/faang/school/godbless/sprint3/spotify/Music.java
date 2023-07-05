package faang.school.godbless.sprint3.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread thread = new Thread(player::play);
        Thread thread1 = new Thread(player::pause);
        Thread thread2 = new Thread(player::skip);
        Thread thread3 = new Thread(player::previous);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
