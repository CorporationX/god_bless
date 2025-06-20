package school.faang.sprint3.bjs2_82139;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println("Fighting");
        boss.leaveBattle(this);
    }
}
