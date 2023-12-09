package faang.school.godbless.Hiroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private static final int MAX_ARMY = 20;
    private String name;
    private String fraction;
    private int experience;
    private int lvl;
    @Getter
    private List<Creature> army = new ArrayList<>(MAX_ARMY);

    public Hero(String name, String fraction, int experience, int lvl) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.lvl = lvl;

    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (army.size() < MAX_ARMY) {
                army.add(creature);
            } else {
                throw new IllegalArgumentException("The " + name + "'s maximum size of the army has been reached");

            }
        }

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
