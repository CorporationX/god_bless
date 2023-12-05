package faang.school.godbless;

public class Archer extends Character{
    private int power;
    private int agility;
    private int intelligence;
    public Archer(String name, int power, int agility, int intelligence){
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    public int attack(Character character) {
        return character.getHealth()-agility;
    }
}
