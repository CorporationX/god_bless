package faang.school.godbless.might.and.magic;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hero {

    @Getter
    private String name;
    private String faction;
    private int experience;
    private int level;
    @Getter
    private List<Creature> army;

    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        for (Creature creature1 : army) {
            if (creature1.getName().equals(creature.getName())) {
                creature1.setQuantity(creature1.getQuantity() + quantity);
                return;
            }
        }
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        for (Creature creature1 : army) {
            if (creature1.getName().equals(creature.getName())) {
                creature1.setQuantity(creature1.getQuantity() - quantity);
                if (creature1.getQuantity() <= 0) {
                    army.remove(creature1);
                }
                return;
            }
        }
    }

    // методы getArmy() и getName() не добавлял потому что есть lombok

}
