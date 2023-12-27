package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

    @SneakyThrows
    public void startBattle(Boss boss) {
        boss.joinBattle(this);
        System.out.println(getName() + " начинает бой");
        Thread.sleep(new Random().nextInt(20000));
        boss.endBattle(this);
    }

}
