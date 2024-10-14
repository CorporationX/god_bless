package school.faang.heroesofmightandmagic;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    // Method to simulate a battle between two armies and return the winning hero
    public Hero battle() {
        int hero1Damage = calculateTotalDamage(hero1);
        int hero2Damage = calculateTotalDamage(hero2);

        System.out.println(hero1.getName() + " Army Total Damage: " + hero1Damage);
        System.out.println(hero2.getName() + " Army Total Damage: " + hero2Damage);

        if (hero1Damage > hero2Damage) {
            System.out.println(hero1.getName() + " wins!");
            return hero1;
        } else if (hero2Damage > hero1Damage) {
            System.out.println(hero2.getName() + " wins!");
            return hero2;
        } else {
            System.out.println("It's a tie!");
            return null;
        }
    }

    // Method to calculate the total damage of a hero's army
    private int calculateTotalDamage(Hero hero) {
        int totalDamage = 0;
        for (Creature creature : hero.getArmy().values()) {
            totalDamage += creature.getDamage();
        }
        return totalDamage;
    }
}

