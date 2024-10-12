package school.faang.BJS2_32902;

import lombok.Getter;
import lombok.Setter;
import school.faang.BJS2_32902.entity.Creature;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;

    @Getter
    private List<Creature> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (creature.getQuantity() >= 0) {
            army.remove(quantity);
        }
    }

}
