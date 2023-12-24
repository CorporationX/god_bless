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
    @SneakyThrows
    public synchronized void joinBattle(Player player) {
        if (maxPlayers - currentPlayers == 0) {
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName()+" successfully join to the battle");
    }

    @SneakyThrows
    public synchronized void completeBattle(Player player) {
        currentPlayers--;
        Thread.sleep(7000);
        System.out.println(player.getName()+" has completed the battle");
        notifyAll();
    }



}
