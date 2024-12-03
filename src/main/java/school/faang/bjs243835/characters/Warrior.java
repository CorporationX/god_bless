package school.faang.bjs243835.characters;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    public void attack(Character target) {
        target.health = Math.max(target.health - this.strength, 0);
    }
}
