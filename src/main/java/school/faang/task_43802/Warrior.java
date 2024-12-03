package school.faang.task_43802;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.setStrength(10);
        this.setAgility(5);
        this.setIntelligence(3);
    }

    @Override
    protected void attack(Character character) {

        System.out.println("Воин атакует");
        character.setHealthPoints(character.getHealthPoints() - this.getStrength());
        System.out.println(character.getName() + " Поймал маслину, у него осталось "
                + character.getHealthPoints() + " HP");
    }

}
