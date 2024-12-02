package school.faang.task_43810;

public class Archer extends Character {
    private static final int POWER = 3;
    private static final int AGILITY = 10;
    private static final int INTELLIGENCE = 5;
    public Archer(String name) {
        super(name, POWER, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        if(character.isAlive()) {
            character.setHp(character.getHp() - AGILITY);
            System.out.println(character.getName() + " hp is " + character.getHp());
        } else {
            System.out.println(character.getName() + " is not alive ");
        }
    }
}
