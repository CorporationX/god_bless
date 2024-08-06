package faang.school.godbless.BJS2_18970;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {
    private static final int SIZE = 10;
    private String name;
    private String fraction;
    private int skill;
    private int level;

    private List<Creature> army;

    public Hero(String name, String fraction, int skill, int level) {
        this.name = name;
        this.fraction = fraction;
        this.skill = skill;
        this.level = level;

        this.army = new ArrayList<>(SIZE);
    }

    public String getName() {
        return name;
    }

    public void addCreature(Creature creature, int quantity) {
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.remove(creature);
    }

    List<Creature> getArmy() {
        return this.army;
    }

    // Проверить работу!!!!!!!!!!!!!
    Creature attack(Hero hero) {
        Random random = new Random();
        int creatureNumber = random.nextInt(army.size() - 1);
        Creature creature = this.army.get(creatureNumber);

        int enemyCreatureNumber = random.nextInt(hero.getArmy().size() - 1);
        Creature enemyCreature = hero.getArmy().get(enemyCreatureNumber);

        enemyCreature.kick(creature.getDamage() + level);

        return enemyCreature.isDead() ? enemyCreature : null;
    }
}
