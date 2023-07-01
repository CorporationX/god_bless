package faang.school.godbless.supercow;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class Boss {
    private int maxPlayers;
    private String name;
    private int currentPlayers;
    private final Lock lock = new ReentrantLock();

    public Boss(String name, int maxPlayers){
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player){
        synchronized (lock){
            if (currentPlayers == maxPlayers){
                try {
                    System.out.println("Maximum players now. Wait a bit");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            currentPlayers++;
        }
    }

    public void finishBattle(Player player){
        synchronized (lock){
            currentPlayers--;
            lock.notify();
        }
    }
}
