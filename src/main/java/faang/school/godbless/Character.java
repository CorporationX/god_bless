package faang.school.godbless;

public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intelligence;
    private int health=100;
    public Character(String name){
        this.name=name;
    }
    public Character(String name, int power, int agility, int intelligence){
        this.name=name;
        this.power=power;
        this.agility=agility;
        this.intelligence=intelligence;
    }

    public int getHealth() {
        return health;
    }

    public abstract int attack(Character character);
}
