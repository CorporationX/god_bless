package faang.school.godbless;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int totalAttack1 = calculateTotalAttack(hero1);
        int totalAttack2 = calculateTotalAttack(hero2);

        System.out.println("Battle starts!");
        System.out.println(hero1.getName() + "'s total attack: " + totalAttack1);
        System.out.println(hero2.getName() + "'s total attack: " + totalAttack2);

        if (totalAttack1 > totalAttack2) {
            System.out.println(hero1.getName() + " wins!");
            return hero1;
        } else if (totalAttack1 < totalAttack2) {
            System.out.println(hero2.getName() + " wins!");
            return hero2;
        } else {
            System.out.println("It's a draw!");
            return null;
        }
    }

    private int calculateTotalAttack(Hero hero) {
        int totalAttack = 0;
        for (Creature creature : hero.getArmy()) {
            totalAttack += creature.getDamage();
        }
        return totalAttack;
    }
}
