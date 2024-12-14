package faang.school.godbless.task18990;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> listOfArmy;

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        listOfArmy = new ArrayList<>();
        level = 1;
        experience = 0;
    }

    public void addCreature (Creature creature, int quantity){
        for (int i = 1; i <= quantity; i++) {
            listOfArmy.add(creature);
        }
    }
    public void removeCreature (Creature creature, String name,  int quantity){
        for (int i = 1; i <= quantity; i++) {
            listOfArmy.remove(creature);
        }
    }
    public List<Creature> getArmy(){
        return listOfArmy;
    }

}
