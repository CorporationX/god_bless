package faang.school.godbless.Task_25;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;

    void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
