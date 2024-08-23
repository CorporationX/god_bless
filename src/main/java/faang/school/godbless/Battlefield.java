package faang.school.godbless;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int damageHero1 = calculateTotalDamage(hero1);
        int damageHero2 = calculateTotalDamage(hero2);

        System.out.println(hero1 + " deals " + damageHero1 + " total damage.");
        System.out.println(hero2 + " deals " + damageHero2 + " total damage.");

        if (damageHero1 > damageHero2) {
            System.out.println(hero1 + " wins the battle!");
            return hero1;
        } else if (damageHero1 < damageHero2) {
            System.out.println(hero2 + " wins the battle!");
            return hero2;
        } else {
            System.out.println("The battle is a draw!");
            return null;
        }
    }

    private int calculateTotalDamage(Hero hero) {
        int totalDamage = 0;
        for (Creature creature : hero.getArmy()) {
            totalDamage += creature.getDamage();
        }
        return totalDamage;
    }
}
