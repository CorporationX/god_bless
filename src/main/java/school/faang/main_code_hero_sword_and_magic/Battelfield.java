package school.faang.main_code_hero_sword_and_magic;

public class Battelfield {
    private Hero firstHero;
    private Hero secondHero;

    public Hero battle(Hero firstHero, Hero secondHero) {
        int firstHeroDamage = calculateDamage(firstHero);
        int secondHeroDamage = calculateDamage(secondHero);

        if (firstHeroDamage > secondHeroDamage) {
            return firstHero;
        } else if (secondHeroDamage > firstHeroDamage) {
            return secondHero;
        } else {
            return null;
        }
    }

    public int calculateDamage(Hero hero) {
        int totalDamage = 0;
        for (Creature creature : hero.getArmy()) {
            totalDamage += creature.getDamage();
        }
        return totalDamage;
    }
}
