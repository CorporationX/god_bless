package faang.school.godbless.thirdSprint.Spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread thread1 = new Thread(player::play);
        Thread thread2 = new Thread(player::skip);
        Thread thread3 = new Thread(player::pause);
        Thread thread4 = new Thread(player::previous);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
