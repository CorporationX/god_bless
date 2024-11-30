package faang.school.godbless.abstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        setStrength(3);
        setDexterity(10);
        setIntelligence(5);
    }

    @Override
    public void attack(Character target) {
        int damage = getDexterity();
        String targetName = target.getName();

        if (damage < target.getHealth()) {
            target.setHealth(target.getHealth() - damage);
            System.out.println("You inflicted " + damage + "  points of damage!");
            System.out.println(targetName + " has" + target.getHealth() + " health left");
        } else {
            target.setHealth(0);
            System.out.println("You killed the " + targetName);
        }
    }
}
