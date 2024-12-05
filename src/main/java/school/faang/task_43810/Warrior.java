package school.faang.task_43810;

public class Warrior extends Character {
    private static final int POWER = 10;
    private static final int AGILITY = 5;
    private static final int INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if (!isAlive()) {
            return;
        }
        character.reduceHp(POWER);
        if (character.isAlive()) {
            System.out.println(character.getName() + " hp is " + character.getHp());
        } else {
            System.out.println(character.getName() + " is not alive ");
        }
    }
}