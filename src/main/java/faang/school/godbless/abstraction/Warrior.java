package faang.school.godbless.abstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        setStrength(10);
        setDexterity(5);
        setIntelligence(3);
    }

    @Override
    public void attack(Character target) {
        int damage = getStrength();
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
