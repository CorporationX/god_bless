package school.faang.bjs249833;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Player {
    public static final int TIME_FIGHT = 2000;
    private String name;

    public void startBattle(@NonNull Boss boss)  {
        try {
            boss.joinBattle(this);
            Thread.sleep(TIME_FIGHT);
        } catch (InterruptedException ex) {
            log.error("Battle start error, player!");
        }
        boss.leaveBattle(this);
    }
}
