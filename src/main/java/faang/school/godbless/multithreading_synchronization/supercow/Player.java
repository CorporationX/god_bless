package faang.school.godbless.multithreading_synchronization.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    @SneakyThrows
    public void startBattle(Boss boss){
        boss.joinBattle(this);
        Thread.sleep(8000);
        boss.leaveBattle(this);
    }
}
