package school.faang.task_43802;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.setStrength(3);
        this.setAgility(10);
        this.setIntelligence(5);
    }

    @Override
    protected void attack(Character character) {

        System.out.println("Робиндуй атакует");
        character.setHealthPoints(character.getHealthPoints() - this.getAgility());
        System.out.println(character.getName() + " Поймал маслину, у него осталось "
                + character.getHealthPoints() + " HP");
    }
}
