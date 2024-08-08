package faang.school.godbless.task18990;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> listOfArmy;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        listOfArmy = new ArrayList<>();
    }

    public void addCreature (Creature creature, int quantity){
        for (int i = 1; i <= quantity; i++) {
            listOfArmy.add(creature);
        }
    }
    public void removeCreature (Creature creature, int quantity){
        for (int i = 1; i <= quantity; i++) {
            listOfArmy.remove(creature);
        }
    }
    public List<Creature> getArmy(){
        return listOfArmy;
    }
}
