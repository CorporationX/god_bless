package src.main.java.faang.school.godbless.BSJS1990;

public abstract class Character {
    protected String name;
    protected int strong;
    protected int agility;
    protected int intel;
    protected int hp ;
    Character(String name){
        this.name = name;
    }

    Character(String name,int strong, int agility, int intel){
        this.name = name;
        this.strong = strong;
        this.agility = agility;
        this.intel = intel;
    }

    public abstract void attack(Character target);


}

