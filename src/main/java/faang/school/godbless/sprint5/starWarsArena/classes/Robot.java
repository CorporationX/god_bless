package faang.school.godbless.sprint5.starWarsArena.classes;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Robot {
    @NonNull
    private String name;
    @NonNull
    private Integer attackPower;
    @NonNull
    private Integer defencePower;
    private int health = 100;

    public void attack(Robot target) {
        int damage = this.attackPower / target.defencePower;
        target.health -= damage;
    }
}
