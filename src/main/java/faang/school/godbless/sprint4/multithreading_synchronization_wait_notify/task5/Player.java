package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {

    private String name;

    public void startBattle(Boss boss) {
        try {
            boss.joinBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBattle(Boss boss) {
        try {
            boss.deleteBattle(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
