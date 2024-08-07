package faang.school.godbless.java.sql.heroes;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Hero {
    @Getter
    private String name;
    @Getter
    private String fraction;
    private int experience;
    private int level;
    private Map<String, Creature> creatureMap = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        creature.setHealth();
        this.creatureMap.put(creature.name, creature);
    }

    public void updateCreature(Creature creature) {
        this.creatureMap.put(creature.name, creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        Creature modifiedCreature = this.creatureMap.get(creature.name);
        modifiedCreature.setQuantity(quantity);

        if (modifiedCreature.quantity == 0) {
            this.creatureMap.remove(creature.name);
        } else {
            this.creatureMap.put(creature.name, modifiedCreature);
        }
    }

    public void getArmy() {
        System.out.print("Army: ");
        for (Map.Entry<String, Creature> entry : creatureMap.entrySet()) {
            System.out.print("<" + entry.getValue() + ">, ");
        }
        System.out.println();
    }

    public Creature getRandomCreature() {
        Random random = new Random();
        Object[] creatures = this.creatureMap.values().toArray();
        System.out.println(this.name + " - " + Arrays.toString(creatures));
        return (Creature) creatures[random.nextInt(creatures.length)];
    }

    public boolean hasArmy() {
        return !this.creatureMap.isEmpty();
    }

}
