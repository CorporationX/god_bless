package faang.school.godbless.javaHashMap.heroes;

public class Battlefield {
    private final Hero allianceHero;
    private final Hero hordeHero;

    public Battlefield(Hero allianceHero, Hero hordeHero) {
        this.allianceHero = allianceHero;
        this.hordeHero = hordeHero;
    }

    public void battle() {
        int allianceHeroAttack = 0;
        int allianceHeroDefence = 0;
        int allianceHeroSpeed = 0;


        for (var entry : allianceHero.getArmy().entrySet()) {
            var quantity = entry.getValue();
            var creature = entry.getKey();

            allianceHeroAttack += quantity * creature.getAttack();
            allianceHeroDefence += quantity * creature.getDefence();
            allianceHeroSpeed += quantity * creature.getSpeed();
        }

        int hordeHeroAttack = 0;
        int hordeHeroDefence = 0;
        int hordeHeroSpeed = 0;

        for (var entry : hordeHero.getArmy().entrySet()) {
            var quantity = entry.getValue();
            var creature = entry.getKey();

            hordeHeroAttack += quantity * creature.getAttack();
            hordeHeroDefence += quantity * creature.getDefence();
            hordeHeroSpeed += quantity * creature.getSpeed();
        }

        System.out.print("!!!");

        if (allianceHeroAttack * allianceHeroDefence * allianceHeroSpeed > hordeHeroAttack * hordeHeroDefence * hordeHeroSpeed) {
            System.out.println("Mighty hero of "
                    + allianceHero.getFraction() + " the great "
                    + allianceHero.getName()
                    + " have won in this spectacular battle versus "
                    + hordeHero.getName() + " (the hero of "
                    + hordeHero.getFraction() + ") ! ");

            return;
        }

        if (allianceHeroAttack * allianceHeroDefence * allianceHeroSpeed < hordeHeroAttack * hordeHeroDefence * hordeHeroSpeed) {
            System.out.println("Brave hero of "
                    + hordeHero.getFraction() + " the great "
                    + hordeHero.getName()
                    + " have won in this spectacular battle versus "
                    + allianceHero.getName() + " (the hero of "
                    + allianceHero.getFraction() + ") ! ");

            return;
        }

        System.out.println("In this spectacular battle no one became winner at the end. Power of both heroes was equal.");
    }
}
