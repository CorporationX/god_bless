package Sprint_4_Task17;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    public void startBattle(Boss boss) {
        synchronized (boss) {
            boss.joinBattle(this);
        }
    }
    public void liftBattles(Boss boss) {
        synchronized (boss) {
            boss.liftBattle(this);
        }
    }
}
