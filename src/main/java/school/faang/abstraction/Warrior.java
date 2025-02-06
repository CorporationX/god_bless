package school.faang.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        super.setStrength(10);
        super.setAgility(5);
        super.setIntelligence(3);
    }

    @Override
    void attack(Character opponent) {
        opponent.HP -= getStrength();
    }


}
