package heroes_of_might_and_magic;

import heroes_of_might_and_magic.creatures.Creature;

import java.util.Random;

public class Battlefield {
    private static final Random random = new Random();

    Hero hero1;
    Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        while (true) {
            if (hero1.getArmy().isEmpty()) {
                return hero2;
            } else if (hero2.getArmy().isEmpty()) {
                return hero1;
            } else {
                makeTurn();
            }
        }
    }

    private void makeTurn() {
        int rndIntToHero1 = random.nextInt(hero1.getArmy().size());
        int rndIntToHero2 = random.nextInt(hero2.getArmy().size());

        Creature hero1Creature = hero1.getArmy().get(rndIntToHero1);
        Creature hero2Creature = hero2.getArmy().get(rndIntToHero2);

        if (hero1Creature.getSpeed() >= hero2Creature.getSpeed()) {
            damageExchange(hero1Creature, hero2Creature, hero1, hero2);
        } else {
            damageExchange(hero2Creature, hero1Creature, hero2, hero1);
        }
    }

    /* Этот метод описывает "обмен ударами" между двумя существами: сначала удар делает существо1, затем, если сущ-во 2 выживает, отвечает ему
     * в задании попросили добавить поле брони, решил его тут применить, броня просто показывает сопротивление урону в процентах
     */
    private void damageExchange(Creature creature1, Creature creature2, Hero hero1, Hero hero2) {
        makeDamageToCreature(creature1, creature2);
        if(!removeCreatureIfDied(creature2, hero2)) {
            makeDamageToCreature(creature2, creature1);
            removeCreatureIfDied(creature1, hero1);
        }
    }

    private void makeDamageToCreature(Creature creatureFrom, Creature creatureto) {
        int damageTo = creatureFrom.getDamage() * (1 - creatureto.getArmor() / 100);
        creatureto.setHealth(creatureto.getHealth() - damageTo);
        System.out.printf("%s нанес %s %d урона%n",
                creatureFrom.getName(), creatureto.getName(), damageTo);
    }
    /*
    я видел, что например
    в реализации ArrayList в методе remove возвращается сущность, которую удалили,
    вообще норм, то что метод, который по факту void, еще и возвращает что-то?
    не смог придумать название, которое бы говорило, что он что-то возвращает,
    но и не смог придумать, как это все разделить получше
    */
    private boolean removeCreatureIfDied(Creature creature, Hero hero){
        if(creature.getHealth() <= 0){
            hero.removeCreature(creature, 1);
            System.out.printf("Существо %s погибло. У героя %s осталось %d существ%n",
                    creature.getName(), hero.getName(), hero.getArmy().size());
            return true;
        }
        return false;
    }

}
