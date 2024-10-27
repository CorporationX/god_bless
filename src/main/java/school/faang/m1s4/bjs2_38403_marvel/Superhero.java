package school.faang.m1s4.bjs2_38403_marvel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Superhero {
    private final String name;
    private final int strength;
    private final int agility;
    @Setter
    private int hp;
    private Random random = new Random();

    private boolean evadeAttack() {
        int evadeChance = agility * 5;
        return random.nextInt(100) <= evadeChance;
    }

    void attack(Superhero defender) {
        if (defender.evadeAttack()) {
            log.info("{}({} hp) evades attack of {}({} hp)", defender.name, defender.getHp(), name, hp);
        } else {
            log.info("{}({} hp) hits {} ({} hp) for {} damage", name, hp, defender.name, defender.getHp(), strength);
            defender.setHp(defender.getHp() - strength);
        }
    }

    boolean isAlive() {
        return hp > 0;
    }
}
