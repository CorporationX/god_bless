package faang.school.godbless.BJS27979;

import faang.school.godbless.BJS27979.Creatures.Creature;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Data
public class Hero {
    private String name;
    private String faction;
    private int level;
    private List<Creature> army;

    public void addCreature(Creature creature) {
        int index = getIndexByName(creature.getName());
        if (index == -1) {
            army.add(creature);
            creature.setOwner(this);
        } else {
            army.get(index).setQuantity(army.get(index).getQuantity() + creature.getQuantity());
            army.get(index).addTotalHealthByQuantity(creature.getQuantity());
        }
    }

    public int getIndexByName(String name) {
        int result = -1;
        for (int i = 0; i < army.size(); i++) {
            if (army.get(i).getName().equals(name)) {
                return i;
            }
        }
        return result;
    }

    public void removeCreature(String name, int quantity) {
        int index = getIndexByName(name);
        if (index == -1) {
            System.out.println("There's no units with name " + name + " in " + this.name + "'s army");
        } else {
            army.get(index).setQuantity(army.get(index).getQuantity() - quantity);
            army.get(index).addTotalHealthByQuantity(-quantity);
        }
    }

    public boolean checkLoose() {
        Iterator<Creature> iterator = army.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getQuantity() == 0) {
                iterator.remove();
            }
        }
        return army.size() == 0;
    }

    public void printArmy() {
        if (army.size() == 0) {
            System.out.println("Hero " + name + " has no army");
        } else {
            System.out.println("Hero " + name + " has next army: ");
            army.forEach(creature -> System.out.println(creature.getName() + ": " + creature.getQuantity()));
        }
    }
}
