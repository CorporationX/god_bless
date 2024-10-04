package school.faang.homm;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int totalDamageHero1 = hero1.getArmy()
                .stream()
                .mapToInt(Creature::getAmountOfDamage)
                .sum();

        int totalDamageHero2 = hero2.getArmy()
                .stream()
                .mapToInt(Creature::getAmountOfDamage)
                .sum();

        return totalDamageHero1 > totalDamageHero2 ? hero1 : hero2;
    }
}
