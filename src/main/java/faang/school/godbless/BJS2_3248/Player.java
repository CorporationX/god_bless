package faang.school.godbless.BJS2_3248;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.Random;

@Data
public class Player {
    @NonNull
    private String name;

    @SneakyThrows
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        Thread.sleep(new Random().nextInt(5000));
        boss.leaveBattle(this);
    }
}
