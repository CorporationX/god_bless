package school.faang.bjs2_90246;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread t1 = new Thread(player::play);
        t1.start();

        Thread t2 = new Thread(player::pause);
        t2.start();

        Thread t3 = new Thread(player::skip);
        t3.start();

        Thread t4 = new Thread(player::previous);
        t4.start();
    }
}
