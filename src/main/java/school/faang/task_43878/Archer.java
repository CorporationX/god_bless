package school.faang.task_43878;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10,  5);
    }

    @Override
    public void attack(Character character) {
        int damage = getDexterity();
        System.out.println(getName() + " attacking " + character.getName() + "\ndamage " + damage);
        character.setHealth(character.getHealth() - damage);
    }
}
