package faang.school.godbless.BJS2_18922;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hero {
    private String name;
    private String fraction;
    private int level;
    private int experience;
    private final List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction, int level, int experience) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;
        this.experience = experience;
    }

    public void addCreature(Creature creature, int quantity){
        if(quantity < 1){
            throw new IllegalArgumentException("Quantity of creatures cant be less than 1");
        }
        if(this.army.contains(creature)){
            this.army.stream().filter(addedCreature -> addedCreature.equals(creature))
                    .forEach(cr -> cr.setQuantity(cr.getQuantity() + quantity));
        } else {
            creature.setQuantity(quantity);
            this.army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity){
        if(!this.army.contains(creature)){
            throw new IllegalArgumentException(String.format("%s does not have any %s in army", this.name, creature.getName()));
        }

        this.army.stream().filter(addedCreature -> addedCreature.equals(creature)).forEach(cr -> {
            if (cr.getQuantity() - quantity < 0){
                this.army.remove(creature);
            } else {
                cr.setQuantity(cr.getQuantity() - quantity);
            }
        });
    }

//    public void getArmy(){
//        this.army.forEach(System.out::println);
//    }
}
