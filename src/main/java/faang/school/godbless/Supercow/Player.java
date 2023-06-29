package faang.school.godbless.Supercow;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Player {
    @NonNull
    private String name;
    private boolean isConnected = false;

    public void startBattle(Boss boss) throws InterruptedException {
        boss.joinBattle(this);
        System.out.println(name + " is battling the boss.");
        Thread.sleep(2000);
        boss.finishBattle(this);
    }
}
