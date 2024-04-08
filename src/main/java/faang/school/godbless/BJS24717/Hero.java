package faang.school.godbless.BJS24717;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Hero {

    private String name;
    private String faction;
    private int experience = 0;
    private int level = 1;
    private List<Creature> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.stream()
                .filter(c -> c.getName().equals(creature.getName()))
                .findFirst()
                .ifPresent(c -> c.setQuantity(Math.max(0, c.getQuantity() - quantity)));
    }

}
