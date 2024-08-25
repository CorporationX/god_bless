package faang.school.godbless.BJS2_24457;

import lombok.Data;

@Data
public class Player {

    private final String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
    }

    public void finishBattle(Boss boss) {
        boss.disconnectBattle(this);
    }
}
