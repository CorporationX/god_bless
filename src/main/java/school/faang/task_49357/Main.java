package school.faang.task_49357;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();


        final Thread thread1 = new Thread(player::play);
        final Thread thread2 = new Thread(player::play);
        final Thread thread3 = new Thread(player::pause);
        final Thread thread4 = new Thread(player::pause);
        final Thread thread5 = new Thread(player::skip);
        final Thread thread6 = new Thread(player::previous);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

    }
}