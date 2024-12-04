package school.faang;

public class Archer extends Character{
    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setDexterity(10);
        this.setIntelligence(5);
    }
    @Override
    public void attack(Character character) {
        this.setHealth(this.getHealth()-character.getPower());
    }

}
