package school.faang.sprint_1.task_43805;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character character) {
        character.damage(this.dexterity);
        System.out.println(this.name + " damage to " + character.name);
    }
}
