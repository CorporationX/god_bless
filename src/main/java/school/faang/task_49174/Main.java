package school.faang.task_49174;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Thread thread1 = new Thread(player::play);
        Thread thread2 = new Thread(player::pause);
        Thread thread3 = new Thread(player::play);
        Thread thread4 = new Thread(player::skip);
        Thread thread5 = new Thread(player::skip);
        Thread thread6 = new Thread(player::previous);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
