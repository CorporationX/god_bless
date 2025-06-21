package school.faang.sprint3.bjs2_82139;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        try {
            boss.joinBattle(this);
            System.out.println("Fighting");
            Thread.sleep(1000);
            boss.leaveBattle(this);

        } catch (InterruptedException e) {
            boss.leaveBattle(this);
            System.out.println("Ошибка: " + e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
