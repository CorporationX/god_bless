package supercow;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
public class Player {
    private static int idCount = 1;
    private final int id;
    @Setter
    private String name;

    public Player(@NonNull String name) {
        synchronized (Player.class) {
            this.id = idCount++;
        }
        this.name = name;
    }

    public void startBattle(Boss boss) {
        Thread battleThread = new Thread(() -> boss.joinBattle(this));
        battleThread.start();
    }
}
