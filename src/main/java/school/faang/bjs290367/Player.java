package school.faang.bjs290367;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            Thread.sleep(2000);
            // Simulate some battle action
            System.out.println(name + " is fighting in the battle!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Player was interrupted while joining the battle: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            boss.leaveBattle(this);
        }

    }
}
