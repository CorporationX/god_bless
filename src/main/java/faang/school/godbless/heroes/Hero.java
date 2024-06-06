package faang.school.godbless.heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {
    private final String name;
    private final String fraction;
    private final String experience;
    private final int level;

    private final List<Creature> army;

    public Hero(String name, String fraction, String experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCreature(Creature creature) {
        army.add(creature);
    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }

    public List<Creature> getArmy() {
        return army;
    }

    public void showArmy() {
        System.out.println(name);
        for (Creature creature : army) {
            System.out.println("\t" + "Имя: " + creature.getName() + ", здоровье: " + creature.getHealth());
        }
    }

    public Creature getCreature(int index) {
        return army.get(index);
    }

    public Creature chooseCreatureToAttack () {
        Random random = new Random();
        int indexHero = random.nextInt(0, army.size());
        return army.get(indexHero);
    }

    public Creature chooseCreatureBeingAttacked(Hero hero) {
        Random random = new Random();
        int indexHero = random.nextInt(0, hero.getArmy().size());
        return hero.getCreature(indexHero);
    }

    public void hit(Hero hero) {
        Creature creatureToAttack = chooseCreatureToAttack();
        Creature creatureAttacked = chooseCreatureBeingAttacked(hero);
        creatureAttacked.takeDamage(creatureToAttack.getDamage());

        if (!creatureAttacked.isAlive()) {
            hero.removeCreature(creatureAttacked);
        }
    }

}
