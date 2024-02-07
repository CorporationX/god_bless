package BSJS1990;

public abstract class Character {
    protected String name;
    protected int strong;
    protected int agility;
    protected int intel;
    protected int hp ;
    Character(String name){
        this.name = name;
        this.hp = 100;
    }

    Character(String name,int strong, int agility, int intel){
        this.name = name;
        this.strong = strong;
        this.agility = agility;
        this.intel = intel;
        this.hp = 100;
    }

    public abstract void attack(Character target);

}

