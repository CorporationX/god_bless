package faang.school.godbless.ThirdSprint.BJS2_26037;

import java.util.ArrayList;
import java.util.List;

public class Boss {

    int maxPlayers = 2;
    List<Player> currentPlayers = new ArrayList<>();

    public synchronized void joinBattle(Player player) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        while (currentPlayers.size() == maxPlayers) {
            System.out.println(player.getName() + " в ожидании");
            this.wait();
        }
        currentPlayers.add(player);
        System.out.println(player.getName() + " присоеденился к атаке");
    }

    public synchronized void endBattle(Player player) {
        System.out.println(Thread.currentThread().getName());
        currentPlayers.remove(player);
        System.out.println(player.getName() + " покинул битву");
        this.notify();
    }
}
