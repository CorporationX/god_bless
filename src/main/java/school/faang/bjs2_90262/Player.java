package school.faang.bjs2_90262;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Player {
    @Getter
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            boss.leaveBattle(this);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
