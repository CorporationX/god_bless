package HeroesOfMightAndMagic;

public class Battlefield {

    public static void battle(Hero firstHero, Hero secondHero) {
        Hero winner = firstHero.getArmyDamage() > secondHero.getArmyDamage() ? firstHero : secondHero;
        System.out.println("Winner " + winner);
    }
}
