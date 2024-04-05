package HeroesofMightandMagic;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String group;
    private int experience;
    private int level;

    private List<Creature> army;

    public Hero(String name, String group, int experience, int level) {
        this.name = name;
        this.group = group;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity && i < army.size(); i++) {
            if (army.get(i).equals(creature)) {
                army.remove(i);
            }
        }
    }

    public List<Creature> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", experience=" + experience +
                ", level=" + level +
                ", army=" + army +
                '}';
    }
}
