package school.faang_sprint_3.blocking_spotify;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        var thread1 = new Thread(player::play);
        var thread2 = new Thread(player::pause);
        var thread3 = new Thread(player::skip);
        var thread4 = new Thread(player::previous);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
