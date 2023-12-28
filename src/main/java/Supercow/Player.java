package Supercow;

import lombok.Getter;

@Getter
public class Player extends Thread {
    private final String PlayerName;
    private final Boss selectedBoss;

    public Player(String name, Boss selectedBoss) {
        this.PlayerName = name;
        this.selectedBoss = selectedBoss;
    }

    public void startBattle() {
        try {
            selectedBoss.joinBattle(this);
            Thread.sleep(1000);
            selectedBoss.endBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            startBattle();
        }
    }
}
