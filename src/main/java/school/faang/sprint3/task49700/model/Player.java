package school.faang.sprint3.task49700.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
@ToString
public class Player {
    private final String name;

    public void startBattle(Boss boss) {

        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
