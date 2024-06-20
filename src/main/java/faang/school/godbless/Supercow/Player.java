package faang.school.godbless.Supercow;

import lombok.ToString;

@ToString
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);

        Thread.sleep(4000);

        boss.endPlaying(this);
    }
}
