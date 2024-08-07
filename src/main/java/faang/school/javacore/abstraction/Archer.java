package faang.school.javacore.abstraction;

public class Archer extends Character{

    public Archer (){
        super("Archer",3,10,5);
    }

    @Override
    int attack(Character character) {
        System.out.println(this.agility);
        return character.health - this.agility;
    }
}
