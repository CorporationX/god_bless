package school.faang.task_43812;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setPower(10);
        this.setSkill(5);
        this.setIntellect(3);
    }

    @Override
    public void attack(Character character) {
        int newHeroHealthValue = character.getHealth() - this.getPower();
        character.setHealth(newHeroHealthValue);
        System.out.printf("%s атакует %s : здоровье %s = %d %n", this.getName(), character.getName(), character.getName(), character.getHealth());

    }
}
