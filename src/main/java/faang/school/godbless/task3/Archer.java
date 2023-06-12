package faang.school.godbless.task3;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        super.setStrength(3);
        super.setAgility(10);
        super.setIntelligence(5);
    }

    @Override
    protected void attack(Character character) {
        if (!character.isDead()) {
            character.setHealth(character.getHealth() - this.getAgility());
            System.out.println(this.getName() + " has attacked " + character.getName() + ". "
                    + "And now " + character.getName() + " has " + character.getHealth() +
                    " points of health!");
        } else {
            System.out.println(character.getName() + " is dead");
        }
    }
}
