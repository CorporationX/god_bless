package faang.school.godbless.BJS2_447;

public class Warrior extends Character{
    public Warrior(String name){
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intelligence = 3;
    }
    @Override
    public void attack(Character character) {
        character.health-=power;
    }

}
