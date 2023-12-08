package faang.school.godbless.Hiroes;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private static final int MAX_ARMY = 10;
    private String name;
    private String fraction;
    private int experience;
    private int lvl;
    private List<Creature> army = new ArrayList<>(MAX_ARMY);

    public Hero(String name, String fraction, int experience, int lvl) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.lvl = lvl;

    }

    public void addCreature(Creature creature, int quantity) {
                for (int i = 0; i < quantity; i++) {
                    if(army.size()<MAX_ARMY) {
                        army.add(creature);
                    }else {
                        throw new IllegalArgumentException("The " + name + "'s maximum size of the army has been reached");

                    }
                }

    }

    public void removeCreature(Creature creature, int quantity) {
        army.remove(creature);

    }

    public List<Creature> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", fraction='" + fraction + '\'' +
                ", experience='" + experience + '\'' +
                ", lvl=" + lvl +
                ", army=" + army +
                '}';
    }
}
