package school.faang;

public class Warrior extends Character {
    final int classStrength = 10;
    final int classAgility = 5;
    final int classIntelligence = 3;

    public Warrior(String name) {
        super(name);
        super.setStrength(classStrength);
        super.setAgility(classAgility);
        super.setIntelligence(classIntelligence);
    }

    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth() - this.getStrength());
    }
}

