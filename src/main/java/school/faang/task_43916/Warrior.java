package school.faang.task_43916;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.strength = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }


    @Override
    void attack(Character character) {
        character.health -= this.strength;
    }
}
