package faang.school.godbless.game;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String fraction;
    private String experience;
    private int level;
    private List<Creature> armyList;

    public Hero(String name, String fraction, String experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.armyList = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        armyList.add(creature);
    }

    public void removeCreature(Creature creature) {
        for (int i = 0; i < armyList.size(); i++) {
            if (creature.equals(armyList.get(i))) {
                armyList.remove(i);
                break;
            }
        }
    }

    public List<Creature> getArmy() {
        return armyList;
    }

    @Override
    public String toString() {
        return "Hero name=" + name +
                ", fraction=" + fraction +
                ", experience=" + experience + ", level=" + level + ".";
    }
}
