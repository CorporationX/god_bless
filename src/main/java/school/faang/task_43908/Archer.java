package school.faang.task_43908;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = dexterity;
        character.health -= damage;
        System.out.println(this.name + " dealt " + damage + " damage to " + character.name);
    }

}
