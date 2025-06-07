package school.faang.bjs2_79203_abstraction.warriors;

import school.faang.bjs2_79203_abstraction.Character;

public class Warrior extends Character {
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent.isDead()) {
            System.out.printf("%s не атакует, потому что %s уже мёртв.%n", this.name, opponent.getName());
            return;
        }

        opponent.takeDamage(this.strength);
        System.out.printf("%s атакует %s на %d урона (Сила)%n",
                this.name, opponent.getName(), this.strength);
    }
}