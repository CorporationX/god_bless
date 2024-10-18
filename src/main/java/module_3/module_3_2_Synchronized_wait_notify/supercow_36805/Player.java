package module_3.module_3_2_Synchronized_wait_notify.supercow_36805;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void startBattle(@NonNull Boss boss) {
        boss.joinBattle(this);
        System.out.println(name + " начал бой");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boss.leaveBattle(this);
    }
}
