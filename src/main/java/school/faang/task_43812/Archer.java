package school.faang.task_43812;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setSkill(10);
        this.setIntellect(5);
    }


    @Override
    public void attack(Character character) {
        int newHeroHealthValue = character.getHealth() - this.getSkill();
        character.setHealth(newHeroHealthValue);
        System.out.printf("%s атакует %s : здоровье %s = %d %n",
                this.getName(), character.getName(), character.getName(), character.getHealth());
    }
}
