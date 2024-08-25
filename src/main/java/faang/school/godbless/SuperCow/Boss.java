package faang.school.godbless.SuperCow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    public static final int MAX_PLAYERS = 4;
    private List<Thread> currentPlayersSessions;
    private Object lock = new Object();

    public Boss() {
        currentPlayersSessions = new ArrayList<>();
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayersSessions.size() >= MAX_PLAYERS) {
                try {
                    System.out.println("Все слоты забиты");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            Thread newPlayerSession = new Thread(() -> {
                String playerName = player.getName();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock) {
                    leaveBattle(playerName);
                    lock.notifyAll();
                }
            });

            currentPlayersSessions.add(newPlayerSession);
            newPlayerSession.start();
        }
    }

    public void leaveBattle(String playerName) {
        currentPlayersSessions.remove(Thread.currentThread());
        System.out.println(playerName + " закончил битву");
    }
}