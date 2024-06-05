package faang.school.godbless;

public abstract class Character {
    private String name;
    private int healthPoints;
    private int manaPoints;
    private int strengthPoints;
    private int agilityPoints;

    public Character(String name){
        this.name = name;
    }


    public Character(String name, int manaPoints, int strengthPoints, int agilityPoints) {
        this.name = name;
        this.healthPoints = 100;
        this.manaPoints = manaPoints;
        this.strengthPoints = strengthPoints;
        this.agilityPoints = agilityPoints;
    }

    public abstract void attack(Character target);


}


