package task_BJS2_56366;

public class Warrior extends Character {

    @Override
    void attack(Character opponent) {
        int damage = getStrength();
        opponent.setHealth(opponent.getHealth() - damage);
    }

    public Warrior(String name, int strength, int agility, int intelligence) {
        super(name, strength, agility, intelligence);
    }

    public Warrior(String name) {
        super(name);
        super.setStrength(10);
        super.setAgility(5);
        super.setIntelligence(3);
    }
}
