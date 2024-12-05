package school.faang.task_43908;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = strength;
        character.health -= damage;
        System.out.println(this.name + " dealt " + damage + " damage to " + character.name);
    }

}
