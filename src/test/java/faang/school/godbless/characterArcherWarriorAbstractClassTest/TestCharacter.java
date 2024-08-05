package faang.school.godbless.characterArcherWarriorAbstractClassTest;

import faang.school.godbless.characterArcherWarriorAbstractClass.Character;

public class TestCharacter extends Character {

    public TestCharacter(String name, int force, int dexterity, int intelligence) {
        super(name, force, dexterity, intelligence);
    }

    @Override
    public void attack(Character opponent) {
        if (opponent == null) {
            throw new IllegalArgumentException("Opponent cannot be null");
        }
        int damage = this.getForce();
        opponent.setHealth(opponent.getHealth() - damage);
    }
}
