package faang.school.godbless.superCow;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class Boss {
    final Object lock = new Object();
    private int maxPlayers;
    private int currentPlayers;
    private List<Player> playerList = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player){
        synchronized (lock){
            while(currentPlayers == maxPlayers){
                System.out.println(player.getName() + " в листе ожидания");
                try{
                    lock.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            playerList.add(player);
            currentPlayers++;
            System.out.println("Присоединился новый игрок " + player.getName());
        }
    }

    public void leaveBattle(Player player){
        synchronized (lock){
            playerList.remove(player);
            currentPlayers--;
            System.out.println("Игрок " + player.getName() + " закончил сражение");
            lock.notify();
        }
    }
}
