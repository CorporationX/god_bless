package school.faang.bjs2_86417_1_1_2_3_abstraction_abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        super.strength = 3;
        super.dexterity = 10;
        super.intelligence = 5;
    }

    public Integer getDexterity() {
        return this.dexterity;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.getDexterity();
        opponent.checkHealth();
    }

}