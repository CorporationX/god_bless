package school.faang;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name);
        this.setPower(10);
        this.setDexterity(5);
        this.setIntelligence(3);
    }
    @Override
    public void attack(Character character) {
        this.setHealth(this.getHealth()-character.getPower());
    }
}
