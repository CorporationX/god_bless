package faang.school.godbless.BJS2_1238;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(name + " is battling with the boss.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        boss.endBattle(this);
    }
}