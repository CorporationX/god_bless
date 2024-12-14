package faang.school.godbless.sprint_1.task_43932;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setDexterity(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character character) {
        int characterHealthAfterAttack = character.getHealth() - this.getStrength();
        if (characterHealthAfterAttack <= 0) {
            character.setHealth(0);
            System.out.println("Противник " + character + " мёртв!");
            return;
        }
        character.setHealth(characterHealthAfterAttack);
    }

}
