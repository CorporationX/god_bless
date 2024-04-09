package faang.school.godbless.BJS2_5147;

public class Battlefield {
    Hero firstHero = new Hero("Sam", "Knight", 3000, 2);
    Hero secondHero = new Hero("Jack", "Elf", 4000, 3);

    private void createArmyFirstHero() {
        firstHero.addCreature(new Griffin(), 3);
        firstHero.addCreature(new Angel(), 5);
        firstHero.addCreature(new Swordman(), 9);
        firstHero.addCreature(new Pikeman(), 6);
    }

    private void createArmySecondHero() {
        secondHero.addCreature(new Griffin(), 7);
        secondHero.addCreature(new Angel(), 10);
        secondHero.removeCreature(new Angel(), 3);
        secondHero.addCreature(new Swordman(), 8);
        secondHero.addCreature(new Pikeman(), 4);
    }

    public Hero battle() {
        createArmyFirstHero();
        createArmySecondHero();
        int damageFirstHero = 0;
        for (Creature character : firstHero.getCreatures()) {
            damageFirstHero += character.getDamage(character);
        }
        int damageSecondHero = 0;
        for (Creature character : secondHero.getCreatures()) {
            damageSecondHero += character.getDamage(character);
        }
        Hero winner = damageFirstHero > damageSecondHero ? firstHero : secondHero;
        winner.getArmy();
        return winner;
    }
}
