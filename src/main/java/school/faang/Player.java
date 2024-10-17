package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int timeOfBeingInBattle = 20;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
            System.out.println(this.name + " пытается агрить босса");
            boss.joinBattle(this);

            Thread.sleep(timeOfBeingInBattle);
            boss.leaveBattle(this);
    }

}
