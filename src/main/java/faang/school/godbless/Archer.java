package faang.school.godbless;

public class Archer extends Character{

    @Override
    protected void attack(Character character) {
        character.health=character.health-this.force;
    }

    public Archer(String name) {
        super(name);
    }

    public Archer(Long force, Long dexterity, Long intelligence) {
        super(3l, 10l, 5l);
    }
}
