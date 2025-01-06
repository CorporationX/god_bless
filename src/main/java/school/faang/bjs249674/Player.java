package school.faang.bjs249674;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
    }
}
