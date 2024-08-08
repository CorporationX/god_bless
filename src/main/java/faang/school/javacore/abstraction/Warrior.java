package faang.school.javacore.abstraction;

public class Warrior extends Character{

    public Warrior (){
        super(10, 5, 3);
    }

    @Override
    int attack(Character character) {
        return health -= strength;
    }
}
