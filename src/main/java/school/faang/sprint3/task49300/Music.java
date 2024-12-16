package school.faang.sprint3.task49300;

public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        Thread thread1 = new Thread(player::play);
        thread1.start();
        Thread thread2 = new Thread(player::pause);
        thread2.start();
        Thread thread3 = new Thread(player::skip);
        thread3.start();
        Thread thread4 = new Thread(player::previous);
        thread4.start();
        Thread thread5 = new Thread(player::play);
        thread5.start();
        Thread thread6 = new Thread(player::pause);
        thread6.start();
        Thread thread7 = new Thread(player::skip);
        thread7.start();
        Thread thread8 = new Thread(player::previous);
        thread8.start();
        Thread thread9 = new Thread(player::play);
        thread9.start();
        Thread thread10 = new Thread(player::play);
        thread10.start();
    }
}
