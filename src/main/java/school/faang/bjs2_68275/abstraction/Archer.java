package school.faang.bjs2_68275.abstraction;

public class Archer extends Character {
    
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_INTELLIGENCE = 5;
    
    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }
    
    @Override
    void attack(Character opponent) {
        if (isHealthLessZeroAfterAttack(opponent.health, this.agility)) {
            opponent.health = 0;
        } else {
            opponent.health -= this.agility;
        }
    }
}
