package faang.school.godbless.task3;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        super.setStrength(10);
        super.setAgility(5);
        super.setIntelligence(3);
    }

    @Override
    protected void attack(Character character) {
        if (!character.isDead()) {
            character.setHealth(character.getHealth() - this.getStrength());
            System.out.println(this.getName() + " has attacked " + character.getName() + ". "
                    + "And now " + character.getName() + " has " + character.getHealth() +
                    " points of health!");
        } else {
            System.out.println(character.getName() + " is dead");
        }
    }
}
