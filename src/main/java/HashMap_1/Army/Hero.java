package HashMap_1.Army;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Hero {

    public Hero(String name, int level, String fraction) {
        this.name = name;
        this.level = level;
        this.fraction = fraction;
    }

    private String name;
    private int level;
    private String fraction;
    private Map<Creature, Integer> creaturesHero = new HashMap<>();

    public void addCreature(Creature creature, int quantity) {
        if (!(creaturesHero.containsKey(creature))) {
            creaturesHero.put(creature, quantity);
        } else {
            creaturesHero.put(creature, creaturesHero.get(creature) + quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (creaturesHero.containsKey(creature)) {
            if (quantity < creaturesHero.get(creature)) {
                creaturesHero.put(creature, creaturesHero.get(creature) - quantity);
            } else {
                creaturesHero.remove(creature);
            }
        }
    }

    public List<Creature> getArmy() {
        List<Creature> listGet = new ArrayList<>();
        for (Map.Entry<Creature, Integer> entry : creaturesHero.entrySet()) {
            listGet.add(entry.getKey());
        }
        return (ArrayList<Creature>) listGet;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getFraction() {
        return fraction;
    }

    public Map<Creature, Integer> getCreaturesHero() {
        return creaturesHero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name) && Objects.equals(fraction, hero.fraction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fraction);
    }

}
