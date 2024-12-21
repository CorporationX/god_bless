package school.faang.task_49639;


import java.util.ArrayList;
import java.util.List;


public class Boss {
    private int maxPlayers;
    private List<Player> currentBattleGroup;


    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentBattleGroup = new ArrayList<>(maxPlayers);
    }

    public synchronized void joinBattle(Player player) {
        if (currentBattleGroup.size() < maxPlayers) {
            System.out.println("игрок " + player.name + " присоединяется к битве...");
            currentBattleGroup.add(player);
        } else {
            try {
                System.out.println("Все места в битве пока заняты, ожидайте...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("sdfsf" + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentBattleGroup.remove(player);
        System.out.println("игрок" + player.name + " покинул битву");
        notifyAll();
    }
}
