package faang.school.godbless;

public class Archer extends Character{

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attach(Character character){
        character.setHealth(character.getHealth() - this.getSkill());
    }
}
