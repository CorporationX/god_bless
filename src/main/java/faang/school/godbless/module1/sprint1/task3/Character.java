package faang.school.godbless.module1.sprint1.task3;


import lombok.Getter;


public abstract class Character {
    @Getter
    private final String name;
    protected int strange;
    protected int agile;
    protected int intelligence;
    protected int heals;


    public Character(String name) {
        this.name = name;
        this.heals = 100;
    }

    //I don't need that here =/
    public Character(String name, int strange, int agile, int intelligence) {
        this.name = name;
        this.strange = strange;
        this.agile = agile;
        this.intelligence = intelligence;
        this.heals = 100;
    }


    public abstract void attack(Character character);
}
