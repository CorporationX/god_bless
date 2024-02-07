package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

public abstract  class Character {
    @Getter
    @Setter
    protected String name;
    @Setter
    @Getter
    private int power;
    @Setter
    @Getter
    protected int agility;
    @Setter
    @Getter
    protected int intellect;
    @Setter
    @Getter
    protected int health=100;

    public Character(String name){
        this.name=name;
    }
    public Character(String name,int power, int agility, int intellect){
        this.name=name;
        this.power=power;
        this.agility=agility;
        this.intellect=intellect;
    }

    public abstract void attack(Character targetCharacter);

}
