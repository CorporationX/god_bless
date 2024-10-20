package school.faang.spotify;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> threadList = new ArrayList<>();

        Thread thread1 = new Thread(() -> player.play(), "Маша");
        Thread thread2 = new Thread(() -> player.pause(), "Яна");
        Thread thread3 = new Thread(() -> player.play(), "Костя");
        Thread thread4 = new Thread(() -> player.skip(), "Вася");
        Thread thread5 = new Thread(() -> player.previous(), "Егор");

        threadList.add(thread1);
        threadList.add(thread2);
        threadList.add(thread3);
        threadList.add(thread4);
        threadList.add(thread5);

        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread threads : threadList) {
            try {
                threads.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
