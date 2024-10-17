package mod1sp12.abstractionAbstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character target) {
        target.hp -= power;
    }
}
