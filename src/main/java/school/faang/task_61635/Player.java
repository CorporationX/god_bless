package school.faang.task_61635;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);

        try {
            log.info("Игрок {} сражается с боссом", name);
            Thread.sleep(2300);
        } catch (InterruptedException e) {
            log.error("Поток был прерван на игроке {}", name);
        }
        boss.leaveBattle(this);
    }
}
