package faang.school.godbless.BJS2_1149;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (maxPlayers - currentPlayers == 0) {
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName()+" successfully join to the battle");
    }


    public synchronized void completeBattle(Player player) throws InterruptedException {
        Thread.sleep(7000);
        System.out.println(player.getName()+" has completed the battle");
        currentPlayers--;
        notifyAll();
    }



}
