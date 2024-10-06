package school.faang.main_code_abstraction;

public class Archer extends Character {
    public Archer(String name, int strengh, int dexterity, int intelligence) {
        super(name, strengh, dexterity, intelligence);
    }

    @Override
    public void attack(Character character) {
        character.couseDamage(getDexterity());
    }
}