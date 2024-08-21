package faang.school.godbless.SuperCow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    public static final int MAX_PLAYERS = 4;
    private List<Thread> currentPlayersSessions;

    public Boss() {
        currentPlayersSessions = new ArrayList<>();
    }

    public synchronized void joinBattle(Player player) {
        Thread newPlayerSession = new Thread(() -> {
            String playerName = player.getName();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {
                currentPlayersSessions.remove(Thread.currentThread());
                System.out.println(playerName + " закончил битву");
                notify();
            }
        });

        while (currentPlayersSessions.size() >= MAX_PLAYERS) {
            try {
                System.out.println("все слоты забиты");
                wait();
                System.out.println("оп освободился");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayersSessions.add(newPlayerSession);
        newPlayerSession.start();
    }
}