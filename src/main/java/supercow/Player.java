package supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    @SneakyThrows
    public void startBattle(Boss boss){
        boss.joinBattle(this);
        System.out.println("вот он босс (сражение) - да прибудит с тобой сила!");
        Thread.sleep(2000);
        boss.endBattle(this);
    }
}
