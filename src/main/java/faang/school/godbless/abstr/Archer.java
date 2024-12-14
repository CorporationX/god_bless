package faang.school.godbless.abstr;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setAgility(10);
        this.setIntellect(5);
    }

    @Override
    public void attack(Character character) {
        int targetHealth = character.getHealth();
        int damage = this.getAgility();
        int resultHealth = targetHealth-damage;
        character.setHealth(resultHealth);
    }
}
