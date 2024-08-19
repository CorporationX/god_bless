package faang.school.godbless.heroes;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;

    private List<Creature> army;

    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCreature(Creature creature, int quantity) {
        for (Creature c : army) {
            if (c.getName().equals(creature.getName())) {
                c.setQuantity(c.getQuantity() + quantity);
                return;
            }
        }

        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        for (Creature c : army) {
            if (c.getName().equals(creature.getName())) {
                int newQuantity = c.getQuantity() - quantity;
                if (newQuantity <= 0) {
                    army.remove(c);
                } else {
                    c.setQuantity(newQuantity);
                }
                return;
            }
        }
    }

    public List<Creature> getArmy() {
        return army;
    }
}
