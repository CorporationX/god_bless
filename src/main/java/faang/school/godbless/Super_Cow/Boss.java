package faang.school.godbless.Super_Cow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Boss {
    private int maxPlayer;
    private List<Player> currentPlayers;
    private Object lock;

    public Boss(int maxPlayer, List<Player> currentPlayers) {
        this.maxPlayer = maxPlayer;
        this.currentPlayers = currentPlayers;
        this.lock = new Object();
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (maxPlayer <= currentPlayers.size()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentPlayers.add(player);
        }
    }
    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers.remove(player);
        }
    }
    public void startBattle(Boss boss,Player player) {
            boss.joinBattle(player);
            boss.leaveBattle(player);

    }
}
