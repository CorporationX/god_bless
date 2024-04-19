package faang.school.godbless.bjs2_5619;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Player {

    private String name;

    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        boss.leaveBattle(this);
    }
}
