package school.faang;

public class Archer extends Character {
    final int classStrength = 3;
    final int classAgility = 8;
    final int classIntelligence = 5;

    public Archer(String name) {
        super(name);
        super.setStrength(classStrength);
        super.setAgility(classAgility);
        super.setIntelligence(classIntelligence);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.getAgility());
    }
}
