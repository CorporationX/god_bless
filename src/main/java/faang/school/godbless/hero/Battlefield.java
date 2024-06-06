package faang.school.godbless.hero;

public class Battlefield {
    private Hero atteckHero;
    private Hero defenderHero;

    public Battlefield(Hero atteckHero, Hero defenderHero) {
        if (atteckHero.getHeroArmy().isEmpty() && defenderHero.getHeroArmy().isEmpty()) {
            throw new IllegalArgumentException("Heroes don't have armies; it's impossible to fight");
        }
        this.atteckHero = atteckHero;
        this.defenderHero = defenderHero;
    }

    public Hero fight() {
        if (defenderHero.getHeroArmy().isEmpty() || atteckHero.getHeroArmy().isEmpty()) {
            Hero winHero = defenderHero.getHeroArmy().isEmpty() ? atteckHero : defenderHero;
            return winHero;
        }
    }
}
