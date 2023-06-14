package faang.school.godbless;

public class Warrior extends Character{
    public Warrior(String name, int power, int dexterity, int brain) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character){
        character.setHealth(character.getHealth()-getPower());
    }
}
