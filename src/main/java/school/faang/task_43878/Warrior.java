package school.faang.task_43878;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = getStrength();
        System.out.println(getName() + " атакует " + character.getName() + "\ndamage " + getStrength());
        character.setHealth(character.getHealth() - damage);
    }

}

