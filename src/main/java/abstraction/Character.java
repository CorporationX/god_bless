package abstraction;

import lombok.Data;

@Data
 abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int hp = 100;

    protected Character (String name){
        this.name = name;
    }
    protected Character (String name, int strength, int dexterity, int intelligence){
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack (Character character);

}
