package school.faang.bro_force;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int hp;

    public void losingHp() {
        hp--;
    }
    @Override
    public String toString() {
        return name;
    }
}
