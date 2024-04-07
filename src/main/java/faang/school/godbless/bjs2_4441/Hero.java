package faang.school.godbless.bjs2_4441;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(exclude = "army")
public class Hero {

    private String name;
    private String group;
    private int experience;
    private int level;
    @Getter
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
        for (int i = 0; i < army.size() && quantity > 0; i++) {
            if (army.get(i).equals(creature)) {
                army.remove(i);
                quantity--;
            }
        }
    }

}
