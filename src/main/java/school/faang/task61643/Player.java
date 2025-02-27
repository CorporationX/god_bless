package school.faang.task61643;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss, Player player) {
        boss.joinBattle(player);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error thread sleeping", e);
        }
        boss.leaveBattle(player);
    }
}
