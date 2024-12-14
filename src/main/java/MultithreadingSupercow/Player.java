package MultithreadingSupercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;

    public synchronized void startBattle(Boss boss) throws InterruptedException {
        if (boss.getCurrentPlayers() == boss.getMaxPlayers()) {
            this.wait();
        }
        boss.joinBattle(this);
    }
}
