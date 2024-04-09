package faang.school.godbless.module.hashmap.heroes.hero;

import java.util.HashMap;
import java.util.Map;

import faang.school.godbless.module.hashmap.heroes.creature.Creature;
import lombok.Getter;

@Getter
public abstract class Hero {
    protected String name;
    protected String fraction;
    protected int experience = 0;
    protected int level = 0;
    
    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
    }
    
    protected Map<Creature, Integer> army = new HashMap<>();
    
    public void addCreature(Creature creature, int quantity) {
        army.put(creature, quantity);
    }
    
    /**
     * Знаю, что не используется, но нет времени делать логику по игре. Надо делать спринт модуль по SQL Если бы
     * реализовал нормально, убирал бы существо из мапы и сравнивал количество оставшихся существ в армии
     */
    public void removeCreature(Creature creature, int quantity) {
        army.computeIfPresent(creature, (key, value) -> {
            int result = value - quantity;
            if (result < 0) {
                result = 0;
            }
            return result;
        });
    }
}
