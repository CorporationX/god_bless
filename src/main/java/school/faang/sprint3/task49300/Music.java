package school.faang.sprint3.task49300;

public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        Thread thread1 = new Thread(player::play);
        Thread thread2 = new Thread(player::pause);
        Thread thread3 = new Thread(player::skip);
        Thread thread4 = new Thread(player::previous);
        Thread thread5 = new Thread(player::play);
        Thread thread6 = new Thread(player::pause);
        Thread thread7 = new Thread(player::skip);
        Thread thread8 = new Thread(player::previous);
        Thread thread9 = new Thread(player::play);
        Thread thread10 = new Thread(player::play);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }
}
