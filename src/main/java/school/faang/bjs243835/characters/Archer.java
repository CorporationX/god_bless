package school.faang.bjs243835.characters;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.strength = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }

    @Override
    public void attack(Character target) {
        if (target == null) {
            return;
        }
        target.setHealth(calculateDamage(target.getHealth(), this.dexterity));
    }
}
