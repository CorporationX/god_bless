package Supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        Boss boss = new Boss("Джаггернаут");
        for (int i = 0; i <= 6; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> new Player("Player" + finalI).startBattle(boss));
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Все потоки закончили работу!");
    }
}
