package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> armyHero = new ArrayList<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getFraction() {
        return fraction;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public List<Creature> getArmyHero() {
        return armyHero;
    }

    public void addCreature(Creature creature) {
        armyHero.add(creature);
    }

    public void removeCreatur(Creature creature) {
        armyHero.remove(creature);
    }

    public List<Creature> getArmy() {
        List<Creature> outArmy = new ArrayList<>(armyHero);
        return outArmy;
    }

    public int totalDamageArmy(List<Creature> army) {
        int countDamage = 0;
        for (Creature unit : army) {
            countDamage += unit.getDamage() * unit.getQuality();
        }
        return countDamage;
    }

}
