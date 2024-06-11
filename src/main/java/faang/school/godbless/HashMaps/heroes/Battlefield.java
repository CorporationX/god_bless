package faang.school.godbless.HashMaps.heroes;

import java.util.List;

public class Battlefield {
    private final List<Hero> heroes;

    public Battlefield(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void battle() {
        boolean battlefieldContinue = true;
        int count = 0;
        while (battlefieldContinue) {
            System.out.println("Раунд " + ++count);
            for (int i = 0; i < heroes.size(); i ++) {
                Hero firstHero = heroes.get(i);
                Hero secondHero = heroes.get(heroes.size() - 1 - i);
                if (!firstHero.getArmy().isEmpty()) {
                    firstHero.hit(secondHero);
                }
                if (secondHero.getArmy().isEmpty()) {
                    System.out.println("Победил " + firstHero.getName());
                    return;
                }
            }
            System.out.println("Состояние армий в конце раунда");
            heroes.get(0).showArmy();
            heroes.get(1).showArmy();
            System.out.println();
        }
    }
}
