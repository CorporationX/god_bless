package Supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss implements Runnable{
    private static final int maxPlayers = 3;
    private final List<Player> currentPlayers = new ArrayList<>();
    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (maxPlayers < currentPlayers.size()-1){
            addPlayer(player);
            System.out.println("Игрок " + player.getName() + " присоединился");
        } else {
            wait();
        }
    }

    public synchronized void endBattle(){
        System.out.println("Сражение окончено!");
        currentPlayers.clear();
        notify();
    }

    private void addPlayer(Player player){
        currentPlayers.add(player);
    }

    @Override
    public void run() {
        while (true){
            if (currentPlayers.size() == maxPlayers){
                System.out.println("Битва начинается!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                endBattle();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
