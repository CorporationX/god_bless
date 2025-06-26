package school.faang.supercow;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private final String name;
    @Setter
    private boolean battle = false;

    public Player(String name) {
        this.name = name;
    }

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }
    }
}