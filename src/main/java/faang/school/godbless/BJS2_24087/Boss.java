package faang.school.godbless.BJS2_24087;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers, int currentPlayers) {
        if (currentPlayers > maxPlayers)
            throw new IllegalArgumentException("Too much players fo this boss");

        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
    }

    public synchronized void joinBattle(Player player) {
        try {
            if (this.maxPlayers == currentPlayers){
                log.info("{} is waiting to enter the boss fight", player.name());
                this.wait();
            }

            log.info("{} is starting fight!", player.name());
            currentPlayers++;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void endBossFight(Player player){
        log.info("{} has left the fight", player.name());
        currentPlayers--;
        this.notify();
    }
}
