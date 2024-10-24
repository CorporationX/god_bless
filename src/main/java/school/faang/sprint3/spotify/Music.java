package school.faang.sprint3.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread t1 = new Thread(player::play);
        Thread t2 = new Thread(player::pause);
        Thread t3 = new Thread(player::play);
        Thread t4 = new Thread(player::previous);
        Thread t5 = new Thread(player::skip);
        Thread t6 = new Thread(player::play);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
