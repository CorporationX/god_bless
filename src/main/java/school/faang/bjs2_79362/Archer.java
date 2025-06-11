package school.faang.bjs2_79362;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {

    private static final int DEFAULT_STRENGTH = 3;
    private static final int DEFAULT_AGILITY = 10;
    private static final int DEFAULT_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name);
        this.strength = DEFAULT_STRENGTH;
        this.agility = DEFAULT_AGILITY;
        this.intelligence = DEFAULT_INTELLIGENCE;
    }

    @Override
    public void attack(Character opponent) {
        log.info(name + " атакует " + opponent.getName() +
                " с силой удара равной ловкости " + agility);
        opponent.reduceHealth(agility);
    }
}

