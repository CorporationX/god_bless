package supercow;

import lombok.Getter;

@Getter
public class Player implements Runnable {
    private final String name;
    private final Boss boss;

    public Player(String name, Boss boss) {
        this.name = name;
        this.boss = boss;
    }

    public void startBattle() {
        boss.goIntoBattle(this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
            System.out.println(name + " был прерван");
        } finally {
            boss.leaveBattle(this);
        }
    }

    @Override
    public void run() {
        startBattle();
    }
}
