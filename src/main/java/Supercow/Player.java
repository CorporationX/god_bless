package Supercow;

import lombok.Getter;

@Getter
public class Player implements Runnable{
    private final String name;
    private Boss selectedBoss;

    public Player(String name, Boss selectedBoss) {
        this.name = name;
        this.selectedBoss = selectedBoss;
    }

    public void startBattle() throws InterruptedException {
        selectedBoss.joinBattle(this);
    }

    @Override
    public void run() {
        try {
            startBattle();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
