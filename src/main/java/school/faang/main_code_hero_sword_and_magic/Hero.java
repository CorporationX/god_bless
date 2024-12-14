package school.faang.main_code_hero_sword_and_magic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int lvl;
    private List<Creature> army;

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        int count = 0;
        for (int i = 0; i < army.size() && count < quantity; i++) {
            if (army.get(i).equals(creature.getName())) {
                army.remove(i);
                count++;
                i--;
            }
        }
    }

    public List<Creature> getArmy() {
        return army;
    }
}
