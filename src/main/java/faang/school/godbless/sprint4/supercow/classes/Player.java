package faang.school.godbless.sprint4.supercow.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    @SneakyThrows
    public void startBattle(Boss boss) {
        boss.joinBattle(this);

        Thread.sleep(5_000);

        boss.endBattle();
    }
}
