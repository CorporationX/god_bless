package faang.school.godbless.sprint_1.task_43932;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setDexterity(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(Character character) {
        int characterHealthAfterAttack = character.getHealth() - this.getDexterity();
        if (characterHealthAfterAttack <= 0) {
            character.setHealth(0);
            System.out.println("Противник " + character + " мёртв!");
            return;
        }
        character.setHealth(characterHealthAfterAttack);
    }
}
