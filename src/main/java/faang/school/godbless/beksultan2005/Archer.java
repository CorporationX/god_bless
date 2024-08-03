package faang.school.godbless.beksultan2005;

public class Archer extends Character{
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public void attack(Character character){
        character.setHealth(character.getHealth()-getDexterity());
    }
}
