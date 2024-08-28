package faang.school.godbless;

import lombok.Getter;

import java.util.*;

@Getter
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private List<Creature> army;

    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        Creature existing = findCreature(creature.name);
        if (existing != null) {
            existing.quantity += quantity;
        } else {
            Creature newCreature = createCreature(creature);
            newCreature.quantity = quantity;
            army.add(newCreature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        Creature existing = findCreature(creature.name);
        if (existing != null) {
            existing.quantity -= quantity;
            if (existing.quantity <= 0) {
                army.remove(existing);
            }
        }
    }

    private Creature findCreature(String name) {
        for (Creature c : army) {
            if (c.name.equals(name)) {
                return c;
            }
        }
        return null;
    }

    private Creature createCreature(Creature creature) {
        if (creature instanceof Pikeman) return new Pikeman();
        if (creature instanceof Griffin) return new Griffin();
        if (creature instanceof Swordman) return new Swordman();
        if (creature instanceof Angel) return new Angel();
        return null;
    }

    @Override
    public String toString() {
        return name + " (Faction: " + faction + ", Level: " + level + ")";
    }}
