package heroesofswordandmagic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hero {

    private String name;
    private String fraction;
    private int exp;
    private int level;
    private List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction, int exp, int level) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
        System.out.println(army);
    }

    public void removeCreature(Creature creature, int quantity) {
        int count = 0;
        for (int i = 0; i < army.size(); i++) {
            if (army.get(i).equals(creature)) {
                army.remove(i);
                count++;
                i--;
            }
            if (count == quantity) {
                break;
            }
        }
        System.out.println(army);
    }

    public List<Creature> getArmy() {
        return army;
    }
}
