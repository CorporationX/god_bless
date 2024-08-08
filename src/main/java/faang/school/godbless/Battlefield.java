package faang.school.godbless;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int hero1TotalDamage = hero1.getArmy().stream().mapToInt(Creature::getDamage).sum();
        int hero2TotalDamage = hero2.getArmy().stream().mapToInt(Creature::getDamage).sum();

        if (hero1TotalDamage > hero2TotalDamage) {
            System.out.println(hero1 + " wins the battle!");
            return hero1;
        } else if (hero2TotalDamage > hero1TotalDamage) {
            System.out.println(hero2 + " wins the battle!");
            return hero2;
        } else {
            System.out.println("The battle is a draw!");
            return null;
        }
    }
}
