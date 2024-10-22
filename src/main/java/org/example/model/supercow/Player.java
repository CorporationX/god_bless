package org.example.model.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public class Player {
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
    }

    public void endBattle(Boss boss) {
        boss.setMaxPlayers(boss.getCurrentPlayers() - 1);
        boss.endTheBattle(this);
    }
}
