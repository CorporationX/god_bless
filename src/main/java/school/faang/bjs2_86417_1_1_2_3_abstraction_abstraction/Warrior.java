package school.faang.bjs2_86417_1_1_2_3_abstraction_abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        super.strength = 10;
        super.dexterity = 5;
        super.intelligence = 3;
    }

    public Integer getStrength() {
        return this.strength;
    }

    @Override
    public void attack(Character opponent) {
        opponent.health -= this.getStrength();
        opponent.checkHealth();
    }
}
