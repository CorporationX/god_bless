package faang.school.godbless.beksultan2005;

public class Warrior extends Character{
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    public void attack(Character character){
        character.setHealth(character.getHealth()-getPower());
    }
}
