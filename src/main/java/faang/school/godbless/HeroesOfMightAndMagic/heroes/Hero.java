package faang.school.godbless.HeroesOfMightAndMagic.heroes;

import faang.school.godbless.HeroesOfMightAndMagic.creatures.Creature;
import lombok.Data;
import lombok.Getter;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    @Getter
    private Map<Creature, Integer> army;

    public Hero(String name, String faction, int experience, int level) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (faction == null) {
            throw new IllegalArgumentException("faction cannot be null");
        }
        if (experience < 0) {
            throw new IllegalArgumentException("experience cannot be less than 0");
        }
        if (level < 0) {
            throw new IllegalArgumentException("level cannot be less than 0");
        }

        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (creature == null) {
            throw new IllegalArgumentException("Creature cannot be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity cannot be less or equal to zero");
        }

        army.merge(creature, quantity, Integer::sum);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (creature == null) {
            throw new IllegalArgumentException("Creature cannot be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity cannot be less or equal to zero");
        }

        army.computeIfPresent(creature, (key, currentQuantity) -> {
            int newQuantity = currentQuantity - quantity;
            return newQuantity > 0 ? newQuantity : null;
        });
    }

    public boolean isAlive()  {
        return !this.army.isEmpty();
    }

    public Optional<Creature>getWeakestCreature() {
        Creature weakestCreature = null;

        for (Creature creature : army.keySet()) {
            if (weakestCreature == null || creature.getDefense() < weakestCreature.getDefense()) {
                weakestCreature = creature;
            }
        }

        return Optional.ofNullable(weakestCreature);
    }

    public String armyToSting() {
        return getArmy().entrySet().stream()
                .map(entry -> entry.getValue() + " " + entry.getKey().getName())
                .collect(Collectors.joining(", "));
    }
}