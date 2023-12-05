package faang.school.godbless;

public class Warrior extends Character{
    private int power;
    private int agility;
    private int intelligence;
    public Warrior(String name, int power, int agility, int intelligence){
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    public int attack(Character character) {
        return character.getHealth()-power;
    }

}
