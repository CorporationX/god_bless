package game;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    void attack(Character character) {
        System.out.printf("%s атакует %s!", getName(), character.getName());
        character.inflictDamage(this.getDexterity());
    }
}
