package school.faang.task_49664;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;

    @SneakyThrows
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        Thread.sleep(2000);
        boss.leaveBattle(this);
    }
}
