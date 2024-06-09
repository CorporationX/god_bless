package faang.school.godbless.module1.spring1.task8;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Hero {
    private String name;
    private String fraction;
    private Long exp;
    private int lvl;
    @Setter
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int count){
        this.army.put(creature, count);
    }

    public void removeCreature(Creature creature){
        this.army.remove(creature);
    }

}
