package faang.school.godbless.hero;

public class Battlefield {
    private Hero attackHero;
    private Hero defenderHero;

    public Battlefield(Hero attackHero, Hero defenderHero) {
        if (attackHero == null || defenderHero == null) {
            throw new IllegalArgumentException(
                    "One or both heroes do not exist when the class Battlefield is created");
        }
        if (attackHero.getHeroArmy().isEmpty() && defenderHero.getHeroArmy().isEmpty()) {
            throw new IllegalArgumentException("Heroes don't have armies; it's impossible to fight");
        }
        this.attackHero = attackHero;
        this.defenderHero = defenderHero;
    }

    public Hero fight() {
        while (!(attackHero.getHeroArmy().isEmpty() || defenderHero.getHeroArmy().isEmpty())) {
            roundFight(attackHero, defenderHero);
            if (!defenderHero.getHeroArmy().isEmpty()) {
                roundFight(defenderHero, attackHero);
            }
        }
        Hero winHero = defenderHero.getHeroArmy().isEmpty() ? attackHero : defenderHero;
        return winHero;
    }

    private void roundFight(Hero attackHero, Hero defenderHero) {
        int paramDefender;
        int paramAttack = attackHero
                .getHeroArmy()
                .entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getAttack() * entry.getValue())
                .sum();
        var randomGroup = defenderHero
                .getHeroArmy()
                .entrySet()
                .stream()
                .findFirst();
        paramDefender = randomGroup.
                map(creatureIntegerEntry -> creatureIntegerEntry.getKey().getProtection())
                .orElse(1);
        defenderHero.removeCreature(randomGroup.get().getKey(), paramAttack / paramDefender);
    }

}
