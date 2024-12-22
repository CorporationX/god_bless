package school.faang.bjs249674;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }
}
