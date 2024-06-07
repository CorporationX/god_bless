package faang.school.godbless.heroes.of.might.and.magic;

import faang.school.godbless.heroes.of.might.and.magic.creatures.Creature;

public class BattleField {
    public static void battleHero(Hero heroOne, Hero heroTwo) {
        while (true) {
            battleCreature(heroOne, heroTwo);
            if (heroOne.getSquadCreature().isEmpty()) {
                System.out.println(heroTwo.getName() + " WIN");
                break;
            }
            if (heroTwo.getSquadCreature().isEmpty()) {
                System.out.println(heroOne.getName() + " WIN");
                break;
            }
        }
    }

    private static void battleCreature(Hero heroOne, Hero heroTwo) {
        while (true) {
            Creature creatureOne = heroOne.getSquadCreature().get(heroOne.getSquadCreature().size() - 1);
            creatureOne.getDamage(heroTwo.getSquadCreature().get(0));
            if (creatureOne.getHealth() <= 0) {
                heroOne.removeCreature();
                if (heroOne.getSquadCreature().isEmpty()) {
                    break;
                }
            }
            Creature creatureTwo = heroTwo.getSquadCreature().get(0);
            creatureTwo.getDamage(heroOne.getSquadCreature().get(0));
            if (creatureTwo.getHealth() <= 0) {
                heroTwo.removeCreature();
                break;
            }
        }
    }
}
