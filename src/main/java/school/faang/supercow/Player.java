package school.faang.supercow;

import lombok.RequiredArgsConstructor;

import java.sql.SQLOutput;

@RequiredArgsConstructor
public class Player {
    private final String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.println("Игрок " + this.name + ": " + " дерется с боссом");
            Thread.sleep(2000);
            System.out.println("Игрок " + this.name + ": " + " закончил драться с боссом");
            boss.leaveBattle(this);
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ignore.getMessage());
        }
    }
}
