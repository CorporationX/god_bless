package school.faang.bjs249833;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    public static final int TIME_FIGHT = 2000;
    private String name;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        Thread.sleep(TIME_FIGHT);
        boss.leaveBattle(this);
    }
}
