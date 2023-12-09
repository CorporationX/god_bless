package faang.school.godbless;

public class Warrior extends Character{

    @Override
    protected void attack(Character character) {
        character.health=character.health-this.force;
    }

    public Warrior(String name) {
        super(name);
    }

    public Warrior(Long force, Long dexterity, Long intelligence) {
        super(10l, 5l, 3l);
    }
}
