package faang.school.javacore.abstraction;

public class Warrior extends Character{

    public Warrior (){
        super("Warrior",10,5,3);
    }

    @Override
    int attack(Character character) {
        return character.health - this.strength;
    }
}
