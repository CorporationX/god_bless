package HeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int level;

    private List<Creature> army;
    private final int ARMY_MAX_VALUE = 10;
    private int currentArmySize;

    public Hero(String name, String fraction, int exp, int level) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.level = level;
        this.currentArmySize = 0;
        this.army = new ArrayList<>(ARMY_MAX_VALUE);
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (currentArmySize == ARMY_MAX_VALUE) {
                System.out.println("Army is full");
            }
            army.add(creature);
            currentArmySize++;
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (currentArmySize == 0) {
                System.out.println("Army is empty");
            }
            army.remove(creature);
            currentArmySize--;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Creature> getArmy() {
        return army;
    }

    public void setArmy(List<Creature> army) {
        this.army = army;
    }

    public int getCurrentArmySize() {
        return currentArmySize;
    }

    public void setCurrentArmySize(int currentArmySize) {
        this.currentArmySize = currentArmySize;
    }
}
