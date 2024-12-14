package org.example.model.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@AllArgsConstructor
public class Boss {
    public int maxPlayers;
    public int currentPlayers;

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            if(maxPlayers - currentPlayers == 0) {
                this.wait();
            }
            log.info(String.format("player %s joined to the game!%n", player.getName()));
            currentPlayers++;
        }
    }

    public void endTheBattle(Player player) {
        synchronized (this) {
            log.info(String.format("%s is over the game!", player.getName()));
            this.notify();
        }
    }
}
