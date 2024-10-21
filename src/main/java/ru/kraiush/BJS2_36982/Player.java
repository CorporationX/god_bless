package ru.kraiush.BJS2_36982;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private final Object lock = new Object();
    private String name;

    public void startBattle(Boss boss) {
        synchronized (lock) {
            boss.joinBattle(this);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boss.endBattle(this);
        }
    }
}
