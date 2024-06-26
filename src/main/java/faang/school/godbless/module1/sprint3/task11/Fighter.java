package faang.school.godbless.module1.sprint3.task11;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fighter extends Game{
    private String name;
    private int heals;
    private int damage;
    private int defence;
    private int strange;
    private int agile;
    private boolean isAlive;

    public Fighter(String name, int strange, int agile){
        this.name = name;
        this.strange = strange;
        this.agile = agile;
        this.isAlive = true;
        this.heals = strange * 5;
        this.damage = agile * 2;
        this.defence = strange / 4;
    }
}
