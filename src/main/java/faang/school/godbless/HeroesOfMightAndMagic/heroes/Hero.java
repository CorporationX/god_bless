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
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (quantity > 0) {
            army.merge(creature, quantity, Integer::sum);
        } else {
            System.out.print("Invalid adding creature: quantity must be greater than 0");
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (quantity > 0) {
            army.computeIfPresent(creature, (key, currentQuantity) -> {
                int newQuantity = currentQuantity - quantity;
                return newQuantity > 0 ? newQuantity : null;
            });
        } else {
            System.out.print("Invalid adding creature: quantity must be greater than 0");
        }
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