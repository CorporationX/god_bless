package school.faang.task_43916;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }


    @Override
    void attack(Character character) {
        character.health -= this.dexterity;
    }
}
