package school.faang.BJS2_32861_HeroesOfMightAndMagic;

public class Battlefield {
    public Hero battle(Hero firstHero, Hero secondHero) {
        int firstHeroTotalDamage = getHeroTotalDamage(firstHero) + firstHero.getExperience();
        int secondHeroTotalDamage = getHeroTotalDamage(secondHero) + secondHero.getExperience();

        System.out.println("*Strange sounds of the battlefield*");
        System.out.printf(
                "Total damage of %s: %d, total damage of %s: %d\n",
                firstHero.getName(), firstHeroTotalDamage, secondHero.getName(), secondHeroTotalDamage
        );

        return firstHeroTotalDamage != secondHeroTotalDamage
                ? (firstHeroTotalDamage > secondHeroTotalDamage ? firstHero : secondHero)
                : null;
    }

    private int getHeroTotalDamage(Hero hero) {
        return hero.getArmy()
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getDamage() * entry.getValue())
                .sum();
    }
}
