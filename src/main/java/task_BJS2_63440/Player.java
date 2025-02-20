package task_BJS2_63440;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        try {
            System.out.printf("Игрок \"%s\" сражается с боссом\n", name);
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            log.info("Thread: {} was interrupted", Thread.currentThread().getName());
        } finally {
            boss.leaveBattle(this);
        }
    }

}
