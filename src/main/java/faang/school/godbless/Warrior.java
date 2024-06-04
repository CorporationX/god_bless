package faang.school.godbless;

public class Warrior extends Character{

    public Warrior(String name){
        super(name,10,5,3);
    }

    @Override
    public void attach(Character character) {
        character.setHealth(character.getHealth() - this.getPower());
    }
}
