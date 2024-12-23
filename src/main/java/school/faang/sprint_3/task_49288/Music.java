package school.faang.sprint_3.task_49288;

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
    }
}
