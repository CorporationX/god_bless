package school.faang.bjs2_82164;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Data
@Slf4j
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        boss.joinBattle(this);
        log.info("{} is battling {}", name, boss.getName());
        boss.leaveBattle(this);
    }
}
