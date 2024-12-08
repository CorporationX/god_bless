package school.faang.rpg;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, int power, int dexterity, int intellect) {
        super(name, power, dexterity, intellect);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " attacks " + opponent.name);
        opponent.health = opponent.health - this.power;
    }
}
