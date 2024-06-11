package faang.school.godbless.abstr;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.setPower(10);
        this.setAgility(5);
        this.setIntellect(3);
    }
    @Override
    public void attack(Character character) {
        int targetHealth = character.getHealth();
        int damage = this.getPower();
        int resultHealth = targetHealth-damage;
        character.setHealth(resultHealth);
    }
}
